package edu.sunmoon.service;

import edu.sunmoon.dao.OrderDao;
import edu.sunmoon.dto.Order;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class OrderService implements Mservice<Integer, Order> {
    OrderDao dao;
    ConnectionPool pool;

    public OrderService() {
        dao = new OrderDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Order add(Order order) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(order, connection);
            System.out.println("OrderService.add() - " + order);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return order;
    }

    @Override
    public Order modify(Order order) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(order, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return order;
    }

    @Override
    public Boolean remove(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Boolean result = false;
        try {
            connection.setAutoCommit(false);
            result = dao.delete(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public Order get(Integer integer) throws Exception {
        Order order = null;
        Connection connection = pool.getConnection();
        try {
            order = dao.select(integer, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return order;
    }

    @Override
    public List<Order> get() throws Exception {
        List<Order> orders = null;
        Connection connection = pool.getConnection();
        try {
            orders = dao.select(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orders;
    }

    public List<Order> get(String customerId) throws Exception {
        List<Order> orders = null;
        Connection connection = pool.getConnection();
        try {
            orders = dao.selectByCustomerId(customerId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orders;
    }
}
