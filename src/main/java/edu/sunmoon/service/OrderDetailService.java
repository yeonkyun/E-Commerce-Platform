package edu.sunmoon.service;

import edu.sunmoon.dao.OrderDetailDao;
import edu.sunmoon.dto.OrderDetail;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class OrderDetailService implements Mservice<Integer, OrderDetail> {
    OrderDetailDao dao;
    ConnectionPool pool;

    public OrderDetailService() {
        dao = new OrderDetailDao();
        pool = ConnectionPool.create();
    }

    @Override
    public OrderDetail add(OrderDetail orderDetail) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(orderDetail, connection);
            System.out.println("OrderDetailService.add() - " + orderDetail);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orderDetail;
    }

    @Override
    public OrderDetail modify(OrderDetail orderDetail) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(orderDetail, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orderDetail;
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
    public OrderDetail get(Integer integer) throws Exception {
        OrderDetail orderDetail = null;
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            orderDetail = dao.select(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orderDetail;
    }

    @Override
    public List<OrderDetail> get() throws Exception {
        List<OrderDetail> orderDetails = null;
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            orderDetails = dao.select(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orderDetails;
    }

    public List<OrderDetail> getByOrderId(Integer orderId) throws Exception {
        List<OrderDetail> orderDetails = null;
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            orderDetails = dao.selectByOrderId(orderId, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return orderDetails;
    }
}
