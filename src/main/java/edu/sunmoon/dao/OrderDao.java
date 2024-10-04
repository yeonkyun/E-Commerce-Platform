package edu.sunmoon.dao;

import edu.sunmoon.dto.Order;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements DAO<Integer, Order> {
    @Override
    public Order insert(Order order, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_ORDER)) {
            ps.setString(1, order.getCustomerId());
            ps.setString(2, order.getName());
            ps.setString(3, order.getPhone());
            ps.setString(4, order.getAddress1());
            ps.setString(5, order.getAddress2());
            ps.setString(6, order.getZipCode());
            ps.setInt(7, order.getTotalPrice());
            ps.setString(8, order.getStatus());
            ps.executeUpdate();
        }
        return order;
    }

    @Override
    public Order update(Order order, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_ORDER)) {
            ps.setString(1, order.getName());
            ps.setString(2, order.getPhone());
            ps.setString(3, order.getAddress1());
            ps.setString(4, order.getAddress2());
            ps.setString(5, order.getZipCode());
            ps.setInt(6, order.getTotalPrice());
            ps.setString(7, order.getStatus());
            ps.setInt(8, order.getId());
            ps.executeUpdate();
        }
        return order;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_ORDER)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Order select(Integer integer, Connection connection) throws Exception {
        Order order = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ORDER_BY_ID)) {
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("order_id"));
                order.setCustomerId(rs.getString("customer_id"));
                order.setName(rs.getString("name"));
                order.setPhone(rs.getString("phone"));
                order.setAddress1(rs.getString("address1"));
                order.setAddress2(rs.getString("address2"));
                order.setZipCode(rs.getString("zip_code"));
                order.setTotalPrice(rs.getInt("total_price"));
                order.setStatus(rs.getString("status"));
                order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
        }
        return order;
    }

    @Override
    public List<Order> select(Connection connection) throws Exception {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ORDER)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("order_id"));
                order.setCustomerId(rs.getString("customer_id"));
                order.setName(rs.getString("name"));
                order.setPhone(rs.getString("phone"));
                order.setAddress1(rs.getString("address1"));
                order.setAddress2(rs.getString("address2"));
                order.setZipCode(rs.getString("zip_code"));
                order.setTotalPrice(rs.getInt("total_price"));
                order.setStatus(rs.getString("status"));
                order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> selectByCustomerId(String customerId, Connection connection) throws Exception {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ORDER_BY_CUSTOMER_ID)) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("order_id"));
                order.setCustomerId(rs.getString("customer_id"));
                order.setName(rs.getString("name"));
                order.setPhone(rs.getString("phone"));
                order.setAddress1(rs.getString("address1"));
                order.setAddress2(rs.getString("address2"));
                order.setZipCode(rs.getString("zip_code"));
                order.setTotalPrice(rs.getInt("total_price"));
                order.setStatus(rs.getString("status"));
                order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                orders.add(order);
            }
        }
        return orders;
    }
}
