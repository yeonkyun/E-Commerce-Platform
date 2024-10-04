package edu.sunmoon.service;

import edu.sunmoon.dao.CouponBoxDao;
import edu.sunmoon.dto.CouponBox;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class CouponBoxService implements Mservice<Integer, CouponBox> {
    CouponBoxDao dao;
    ConnectionPool pool;

    public CouponBoxService() {
        dao = new CouponBoxDao();
        pool = ConnectionPool.create();
    }

    @Override
    public CouponBox add(CouponBox couponBox) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(couponBox, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return couponBox;
    }

    @Override
    public CouponBox modify(CouponBox couponBox) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(couponBox, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return couponBox;
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
    public CouponBox get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        CouponBox couponBox = null;
        try {
            connection.setAutoCommit(false);
            couponBox = dao.select(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return couponBox;
    }

    @Override
    public List<CouponBox> get() throws Exception {
        Connection connection = pool.getConnection();
        List<CouponBox> couponBoxes = null;
        try {
            connection.setAutoCommit(false);
            couponBoxes = dao.select(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return couponBoxes;
    }

    public List<CouponBox> getByCustomerId(String customerId) throws Exception {
        Connection connection = pool.getConnection();
        List<CouponBox> couponBoxes = null;
        try {
            connection.setAutoCommit(false);
            couponBoxes = dao.selectByCustomerId(customerId, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return couponBoxes;
    }

    public List<CouponBox> getByCouponId(String couponId) throws Exception {
        Connection connection = pool.getConnection();
        List<CouponBox> couponBoxes = null;
        try {
            connection.setAutoCommit(false);
            couponBoxes = dao.selectByCouponId(couponId, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return couponBoxes;
    }
}
