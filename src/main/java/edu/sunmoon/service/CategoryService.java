package edu.sunmoon.service;

import edu.sunmoon.dao.CategoryDao;
import edu.sunmoon.dto.Category;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class CategoryService implements Mservice<Integer, Category> {
    CategoryDao dao;
    ConnectionPool pool;

    public CategoryService() {
        dao = new CategoryDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Category add(Category category) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(category, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return category;
    }

    @Override
    public Category modify(Category category) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.update(category, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return category;
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
    public Category get(Integer integer) throws Exception {
        Category category = null;
        Connection connection = pool.getConnection();
        try {
            category = dao.select(integer, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return category;
    }

    @Override
    public List<Category> get() throws Exception {
        List<Category> categories = null;
        Connection connection = pool.getConnection();
        try {
            categories = dao.select(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return categories;
    }

    public Category getByName(String name) throws Exception {
        Category category = null;
        Connection connection = pool.getConnection();
        try {
            category = dao.selectByName(name, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return category;
    }

    public List<Category> getByParentsId(Integer parentsId) throws Exception {
        List<Category> categories = null;
        Connection connection = pool.getConnection();
        try {
            categories = dao.selectByParentsId(parentsId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return categories;
    }
}
