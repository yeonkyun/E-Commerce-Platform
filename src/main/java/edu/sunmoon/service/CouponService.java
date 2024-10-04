package edu.sunmoon.service;

import edu.sunmoon.dao.CouponDao;
import edu.sunmoon.dto.Coupon;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class CouponService implements Mservice<String, Coupon> {
    CouponDao dao;
    ConnectionPool pool;

    public CouponService() {
        dao = new CouponDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Coupon add(Coupon coupon) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(coupon, connection);
            System.out.println("CouponService.add() - " + coupon);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return coupon;
    }

@Override
public Coupon modify(Coupon coupon) throws Exception {
    Connection connection = pool.getConnection();
    try {
        connection.setAutoCommit(false); // Disable autocommit
        dao.update(coupon, connection);
        connection.commit(); // Commit the transaction
    } catch (Exception e) {
        connection.rollback(); // Rollback the transaction
        throw e;
    } finally {
        connection.setAutoCommit(true); // Restore autocommit
        pool.releaseConnection(connection);
    }
    return coupon;
}

    @Override
    public Boolean remove(String s) throws Exception {
        Connection connection = pool.getConnection();
        Boolean result = false;
        try {
            connection.setAutoCommit(false); // Disable autocommit
            result = dao.delete(s, connection);
            connection.commit(); // Commit the transaction
            System.out.println("CouponService.remove() - " + s);
        } catch (Exception e) {
            connection.rollback(); // Rollback the transaction
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public Coupon get(String s) throws Exception {
        Connection connection = pool.getConnection();
        try {
            return dao.select(s, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<Coupon> get() throws Exception {
        Connection connection = pool.getConnection();
        try {
            return dao.select(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
    }
}
