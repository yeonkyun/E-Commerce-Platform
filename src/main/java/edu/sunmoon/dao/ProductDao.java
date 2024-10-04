package edu.sunmoon.dao;

import edu.sunmoon.dto.Product;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements DAO<Integer, Product> {

    @Override
    public Product insert(Product product, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_PRODUCT)) {
            ps.setInt(1, product.getCategoryId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getPrice());
            ps.setInt(5, product.getStockQuantity());
            ps.setBoolean(6, product.isSelling());
            ps.executeUpdate();
        }
        return product;
    }

    @Override
    public Product update(Product product, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_PRODUCT)) {
            ps.setInt(1, product.getCategoryId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getPrice());
            ps.setInt(5, product.getStockQuantity());
            ps.setBoolean(6, product.isSelling());
            ps.setInt(7, product.getId());
            ps.executeUpdate();
        }
        return product;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_PRODUCT)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Product select(Integer integer, Connection connection) throws Exception {
        Product product = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PRODUCT_BY_ID)) {
            ps.setInt(1, integer);
            var rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setSelling(rs.getBoolean("is_selling"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                product.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            }
        }
        return product;
    }

    @Override
    public List<Product> select(Connection connection) throws Exception {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PRODUCT)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setSelling(rs.getBoolean("is_selling"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                product.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> selectByName(String name, Connection connection) throws Exception {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PRODUCT_BY_NAME)) {
            ps.setString(1, name);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setSelling(rs.getBoolean("is_selling"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                product.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> selectByCategory(Integer categoryId, Connection connection) throws Exception {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PRODUCT_BY_CATEGORY_ID)) {
            ps.setInt(1, categoryId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setSelling(rs.getBoolean("is_selling"));
                product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                product.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                products.add(product);
            }
        }
        return products;
    }
}
