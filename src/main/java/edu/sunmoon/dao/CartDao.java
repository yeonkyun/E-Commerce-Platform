package edu.sunmoon.dao;

import edu.sunmoon.dto.Cart;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDao implements DAO<Integer, Cart> {
    @Override
    public Cart insert(Cart cart, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_CART)) {
            ps.setString(1, cart.getCustomerId());
            ps.setInt(2, cart.getProductId());
            ps.setInt(3, cart.getQuantity());
            ps.setInt(4, cart.getQuantity());
            ps.setInt(5, cart.getProductId());
            ps.executeUpdate();
        }
        return cart;
    }

    @Override
    public Cart update(Cart cart, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_CART)) {
            ps.setInt(1, cart.getQuantity());
            ps.setInt(2, cart.getQuantity());
            ps.setInt(3, cart.getId());
            ps.executeUpdate();
        }
        return cart;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_CART)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Cart select(Integer integer, Connection connection) throws Exception {
        Cart cart = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CART_BY_ID)) {
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cart = new Cart();
                cart.setId(rs.getInt("cart_id"));
                cart.setCustomerId(rs.getString("customer_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setTotalPrice(rs.getInt("total_price"));
                cart.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
        }
        return cart;
    }

    @Override
    public List<Cart> select(Connection connection) throws Exception {
        List<Cart> carts = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CART)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("cart_id"));
                cart.setCustomerId(rs.getString("customer_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setTotalPrice(rs.getInt("total_price"));
                cart.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                carts.add(cart);
            }
        }
        return carts;
    }

    public List<Cart> selectByCustomerId(String customerId, Connection connection) throws Exception {
        List<Cart> carts = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CART_BY_CUSTOMER_ID)) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("cart_id"));
                cart.setCustomerId(rs.getString("customer_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setTotalPrice(rs.getInt("total_price"));
                cart.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                carts.add(cart);
            }
        }
        return carts;
    }

    public List<Cart> selectByProductId(int productId, Connection connection) throws Exception {
        List<Cart> carts = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CART_BY_PRODUCT_ID)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("cart_id"));
                cart.setCustomerId(rs.getString("customer_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setTotalPrice(rs.getInt("total_price"));
                cart.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                carts.add(cart);
            }
        }
        return carts;
    }
}
