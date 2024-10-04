package edu.sunmoon.service;

import edu.sunmoon.dao.CartDao;
import edu.sunmoon.dto.Cart;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class CartService implements Mservice<Integer, Cart> {
    CartDao dao;
    ConnectionPool pool;

    public CartService() {
        dao = new CartDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Cart add(Cart cart) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(cart, connection);
            System.out.println("CartService.add() - " + cart);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return cart;
    }

@Override
public Cart modify(Cart cart) throws Exception {
    Connection connection = pool.getConnection();
    try {
        connection.setAutoCommit(false); // Disable autocommit
        dao.update(cart, connection);
        connection.commit(); // Commit the transaction
    } catch (Exception e) {
        connection.rollback(); // Rollback the transaction
        throw e;
    } finally {
        pool.releaseConnection(connection);
    }
    return cart;
}

    @Override
    public Boolean remove(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Boolean result = false;
        try {
            connection.setAutoCommit(false); // Disable autocommit
            result = dao.delete(integer, connection);
            connection.commit(); // Commit the transaction
            System.out.println("CartService.remove() - " + integer);
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public Cart get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Cart cart = null;
        try {
            cart = dao.select(integer, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return cart;
    }

    @Override
    public List<Cart> get() throws Exception {
        Connection connection = pool.getConnection();
        List<Cart> carts = null;
        try {
            carts = dao.select(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return carts;
    }

    public List<Cart> getByCustomerId(String customerId) throws Exception {
        Connection connection = pool.getConnection();
        List<Cart> carts = null;
        try {
            carts = dao.selectByCustomerId(customerId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return carts;
    }

    public List<Cart> getByProductId(Integer productId) throws Exception {
        Connection connection = pool.getConnection();
        List<Cart> carts = null;
        try {
            carts = dao.selectByProductId(productId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return carts;
    }
}
