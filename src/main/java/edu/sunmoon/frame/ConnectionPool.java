package edu.sunmoon.frame;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 10;
    private static final Properties properties = new Properties();
    private final Lock lock = new ReentrantLock();

    static {
        try (InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("mysql.properties")) {
            if (input == null) {
                throw new RuntimeException("mysql.properties 파일을 찾을 수 없습니다.");
            }
            properties.load(input);
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            System.out.println("데이터베이스 URL: " + properties.getProperty("mysql.url"));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("데이터베이스 속성 로딩 실패", e);
        }
    }

    // ConnectionPool 인스턴스 생성
    public static ConnectionPool create() {
        try {
            String url = properties.getProperty("mysql.url");
            String user = properties.getProperty("mysql.username");
            String password = properties.getProperty("mysql.password");

            List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection(url, user, password));
            }
            return new ConnectionPool(pool);
        } catch (SQLException e) {
            throw new RuntimeException("연결 풀 생성 실패", e);
        }
    }

    private ConnectionPool(List<Connection> connectionPool) {
        this.connectionPool = connectionPool;
    }

    // 연결 가져오기
    public Connection getConnection() throws SQLException {
        lock.lock();
        try {
            if (connectionPool.isEmpty()) {
                if (usedConnections.size() < MAX_POOL_SIZE) {
                    String url = properties.getProperty("mysql.url");
                    String user = properties.getProperty("mysql.username");
                    String password = properties.getProperty("mysql.password");
                    connectionPool.add(createConnection(url, user, password));
                } else {
                    throw new SQLException("최대 풀 크기에 도달했습니다. 사용 가능한 연결이 없습니다!");
                }
            }

            Connection connection = connectionPool.remove(connectionPool.size() - 1);
            if (!connection.isValid(1)) {
                // 연결이 유효하지 않으면 새 연결 생성
                connection = createConnection(properties.getProperty("mysql.url"),
                        properties.getProperty("mysql.username"),
                        properties.getProperty("mysql.password"));
            }
            usedConnections.add(connection);
            return connection;
        } finally {
            lock.unlock();
        }
    }

    // 연결 반환
    public boolean releaseConnection(Connection connection) {
        lock.lock();
        try {
            connectionPool.add(connection);
            return usedConnections.remove(connection);
        } finally {
            lock.unlock();
        }
    }

    // 새 연결 생성
    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 전체 연결 수 반환
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    // 사용 가능한 연결 수 반환
    public int getAvailableConnectionsCount() {
        return connectionPool.size();
    }

    // ConnectionPool 종료
    public void shutdown() throws SQLException {
        usedConnections.forEach(this::releaseConnection);
        for (Connection c : connectionPool) {
            c.close();
        }
        connectionPool.clear();
    }
}