package edu.sunmoon.service;

import edu.sunmoon.dao.UsedCouponDao;
import edu.sunmoon.dto.UsedCoupon;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class UsedCouponService implements Mservice<Integer, UsedCoupon> {
    UsedCouponDao dao;
    ConnectionPool pool;

    public UsedCouponService() {
        dao = new UsedCouponDao();
        pool = ConnectionPool.create();
    }

    @Override
    public UsedCoupon add(UsedCoupon usedCoupon) throws Exception {
        Connection connection = pool.getConnection();
        try {
            dao.insert(usedCoupon, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return usedCoupon;
    }

    @Override
    public UsedCoupon modify(UsedCoupon usedCoupon) throws Exception {
        Connection connection = pool.getConnection();
        try {
            dao.update(usedCoupon, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return usedCoupon;
    }

    @Override
    public Boolean remove(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        try {
            dao.delete(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public UsedCoupon get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        try {
            return dao.select(integer, connection);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<UsedCoupon> get() throws Exception {
        Connection connection = pool.getConnection();
        try {
            return dao.select(connection);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    public List<UsedCoupon> getByOrderDetailId(Integer orderDetailId) throws Exception {
        Connection connection = pool.getConnection();
        try {
            return dao.selectByOrderDetailId(orderDetailId, connection);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    public List<UsedCoupon> getByCouponId(Integer couponId) throws Exception {
        Connection connection = pool.getConnection();
        try {
            return dao.selectByCouponId(couponId, connection);
        } finally {
            pool.releaseConnection(connection);
        }
    }
}
