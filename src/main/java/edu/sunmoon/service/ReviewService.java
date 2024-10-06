package edu.sunmoon.service;

import edu.sunmoon.dao.ReviewDao;
import edu.sunmoon.dto.Review;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class ReviewService implements Mservice<Integer, Review> {
    ReviewDao dao;
    ConnectionPool pool;

    public ReviewService() {
        dao = new ReviewDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Review add(Review review) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(review, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return review;
    }

    @Override
    public Review modify(Review review) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(review, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return review;
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
    public Review get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Review review = null;
        try {
            connection.setAutoCommit(false);
            review = dao.select(integer, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return review;
    }

    @Override
    public List<Review> get() throws Exception {
        Connection connection = pool.getConnection();
        List<Review> reviews = null;
        try {
            connection.setAutoCommit(false);
            reviews = dao.select(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return reviews;
    }

    public List<Review> getByProductId(Integer productId) throws Exception {
        Connection connection = pool.getConnection();
        List<Review> reviews = null;
        try {
            connection.setAutoCommit(false);
            reviews = dao.selectByProductId(productId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return reviews;
    }

    public List<Review> getByCustomerId(String customerId) throws Exception {
        Connection connection = pool.getConnection();
        List<Review> reviews = null;
        try {
            connection.setAutoCommit(false);
            reviews = dao.selectByCustomerId(customerId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            connection.setAutoCommit(true);
            pool.releaseConnection(connection);
        }
        return reviews;
    }
}
