package edu.sunmoon.dao;

import edu.sunmoon.dto.Customer;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements DAO<String, Customer> {
    @Override
    public Customer insert(Customer customer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_CUSTOMER)) {
            ps.setString(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPassword());
            ps.setString(5, customer.getPhone());
            ps.setString(6, customer.getLevel());
            ps.executeUpdate();
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_CUSTOMER)) {
            ps.setString(1, customer.getEmail());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getLevel());
            ps.setString(5, customer.getId());
            ps.executeUpdate();
        }
        return customer;
    }

    @Override
    public Boolean delete(String id, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_CUSTOMER)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Customer select(String id, Connection connection) throws Exception {
        Customer customer = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CUSTOMER_BY_ID)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getString("customer_id"));
                customer.setPassword(rs.getString("password"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setLevel(rs.getString("level"));
                customer.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                customer.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                customer.setStatus(rs.getBoolean("status"));
            }
        }
        return customer;
    }

    @Override
    public List<Customer> select(Connection connection) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CUSTOMER)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("customer_id"));
                customer.setPassword(rs.getString("password"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setLevel(rs.getString("level"));
                customer.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                customer.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                customer.setStatus(rs.getBoolean("status"));
                customers.add(customer);
            }
            return customers;
        }
    }

    public List<Customer> selectByName(String name, Connection connection) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CUSTOMER_BY_NAME)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("customer_id"));
                customer.setPassword(rs.getString("password"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setLevel(rs.getString("level"));
                customer.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                customer.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                customer.setStatus(rs.getBoolean("status"));
                customers.add(customer);
            }
            return customers;
        }
    }
}