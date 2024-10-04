package edu.sunmoon.service;

import edu.sunmoon.dao.AddressDao;
import edu.sunmoon.dto.Address;
import edu.sunmoon.frame.ConnectionPool;
import edu.sunmoon.frame.Mservice;

import java.sql.Connection;
import java.util.List;

public class AddressService implements Mservice<Integer, Address> {
    AddressDao dao;
    ConnectionPool pool;

    public AddressService() {
        dao = new AddressDao();
        pool = ConnectionPool.create();
    }

    @Override
    public Address add(Address address) throws Exception {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            dao.insert(address, connection);
            System.out.println("AddressService.add() - " + address);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return address;
    }

    @Override
    public Address modify(Address address) throws Exception {
        Connection connection = pool.getConnection();
        try {
            dao.update(address, connection);
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return address;
    }

    @Override
    public Boolean remove(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Boolean result = false;
        try {
            connection.setAutoCommit(false); // Disable autocommit
            result = dao.delete(integer, connection);
            connection.commit(); // Commit the transaction
            System.out.println("AddressService.remove() - " + integer);
        } catch (Exception e) {
            connection.rollback(); // Rollback the transaction
            throw e;
        } finally {
            pool.releaseConnection(connection); // Release the connection
        }
        return result;
    }

    @Override
    public Address get(Integer integer) throws Exception {
        Connection connection = pool.getConnection();
        Address address = null;
        try {
            address = dao.select(integer, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return address;
    }

    @Override
    public List<Address> get() throws Exception {
        Connection connection = pool.getConnection();
        List<Address> addresses = null;
        try {
            addresses = dao.select(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return addresses;
    }

    public List<Address> getByCustomerId(String customerId) throws Exception {
        Connection connection = pool.getConnection();
        List<Address> addresses = null;
        try {
            addresses = dao.selectByCustomerId(customerId, connection);
        } catch (Exception e) {
            throw e;
        } finally {
            pool.releaseConnection(connection);
        }
        return addresses;
    }
}
