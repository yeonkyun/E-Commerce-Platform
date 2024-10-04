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
            dao.insert(product, connection);
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
    public Product modify(Product product) throws Exception {
        Connection connection = pool.getConnection();
        try {
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
    public Product get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Product product;
        try {
            product = dao.select(integer, connection);
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
    public List<Product> get() throws Exception {
        Connection connection = pool.getConnection();
        List<Product> products;
        try {
            products = dao.select(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return products;
    }

    public List<Product> getByName(String name) throws Exception {
        Connection connection = pool.getConnection();
        List<Product> products;
        try {
            products = dao.selectByName(name, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return products;
    }

    public List<Product> getByCategory(Integer category) throws Exception {
        Connection connection = pool.getConnection();
        List<Product> products;
        try {
            products = dao.selectByCategory(category, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return products;
    }
}
