package edu.sunmoon.service;

import edu.sunmoon.dao.PaymentDao;
import edu.sunmoon.dto.Payment;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class PaymentService implements Mservice<Integer, Payment> {
    PaymentDao dao;
    ConnectionPool pool;

    public PaymentService() {
        dao = new PaymentDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Payment add(Payment payment) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(payment, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return payment;
    }

    @Override
    public Payment modify(Payment payment) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(payment, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return payment;
    }

    @Override
    public Boolean remove(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.delete(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public Payment get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Payment payment;
        try {
            connection.setAutoCommit(false);
            payment = dao.select(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return payment;
    }

    @Override
    public List<Payment> get() throws Exception {
        Connection connection = pool.getConnection();
        List<Payment> payments;
        try {
            connection.setAutoCommit(false);
            payments = dao.select(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return payments;
    }

    public List<Payment> getByOrderId(Integer orderId) throws Exception {
        Connection connection = pool.getConnection();
        List<Payment> payments;
        try {
            connection.setAutoCommit(false);
            payments = dao.selectByOrderId(orderId, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return payments;
    }

    public List<Payment> getByPaymentMethod(String paymentMethod) throws Exception {
        Connection connection = pool.getConnection();
        List<Payment> payments;
        try {
            connection.setAutoCommit(false);
            payments = dao.selectByPaymentMethod(paymentMethod, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return payments;
    }
}
