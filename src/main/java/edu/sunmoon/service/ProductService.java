package edu.sunmoon.service;

import edu.sunmoon.dao.ProductDao;
import edu.sunmoon.dto.Product;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class ProductService implements Mservice<Integer, Product> {
    ProductDao dao;
    ConnectionPool pool;

    public ProductService() {
        dao = new ProductDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Product add(Product product) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            dao.insert(product, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore auto-commit mode
            pool.releaseConnection(connection);
        }
        return product;
    }

    @Override
    public Product modify(Product product) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            dao.update(product, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return product;
    }

    @Override
    public Boolean remove(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            dao.delete(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore auto-commit mode
            pool.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public Product get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Product product;
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            product = dao.select(integer, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore auto-commit mode
            pool.releaseConnection(connection);
        }
        return product;
    }

    @Override
    public List<Product> get() throws Exception {
        Connection connection = pool.getConnection();
        List<Product> products;
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            products = dao.select(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore auto-commit mode
            pool.releaseConnection(connection);
        }
        return products;
    }

    public List<Product> getByName(String name) throws Exception {
        Connection connection = pool.getConnection();
        List<Product> products;
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            products = dao.selectByName(name, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore auto-commit mode
            pool.releaseConnection(connection);
        }
        return products;
    }

    public List<Product> getByCategory(Integer category) throws Exception {
        Connection connection = pool.getConnection();
        List<Product> products;
        try {
            connection.setAutoCommit(false); // Disable auto-commit mode
            products = dao.selectByCategory(category, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore auto-commit mode
            pool.releaseConnection(connection);
        }
        return products;
    }
}
