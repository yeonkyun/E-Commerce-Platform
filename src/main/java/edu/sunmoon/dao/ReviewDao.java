package edu.sunmoon.dao;

import edu.sunmoon.dto.Review;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao implements DAO<Integer, Review> {
    @Override
    public Review insert(Review review, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_REVIEW)) {
            ps.setInt(1, review.getProductId());
            ps.setString(2, review.getCustomerId());
            ps.setFloat(3, review.getRating());
            ps.setString(4, review.getContent());
            ps.executeUpdate();
        }
        return review;
    }

    @Override
    public Review update(Review review, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_REVIEW)) {
            ps.setFloat(1, review.getRating());
            ps.setString(2, review.getContent());
            ps.setInt(3, review.getId());
            ps.executeUpdate();
        }
        return review;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_REVIEW)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Review select(Integer integer, Connection connection) throws Exception {
        Review review = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_REVIEW_BY_ID)) {
            ps.setInt(1, integer);
            var rs = ps.executeQuery();
            if (rs.next()) {
                review = new Review();
                review.setId(rs.getInt("review_id"));
                review.setProductId(rs.getInt("product_id"));
                review.setCustomerId(rs.getString("customer_id"));
                review.setRating(rs.getFloat("rating"));
                review.setContent(rs.getString("content"));
                review.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
        }
        return review;
    }

    @Override
    public List<Review> select(Connection connection) throws Exception {
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_REVIEW)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("review_id"));
                review.setProductId(rs.getInt("product_id"));
                review.setCustomerId(rs.getString("customer_id"));
                review.setRating(rs.getFloat("rating"));
                review.setContent(rs.getString("content"));
                review.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                reviews.add(review);
            }
        }
        return reviews;
    }

    public List<Review> selectByProductId(Integer productId, Connection connection) throws Exception {
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_REVIEW_BY_PRODUCT_ID)) {
            ps.setInt(1, productId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("review_id"));
                review.setProductId(rs.getInt("product_id"));
                review.setCustomerId(rs.getString("customer_id"));
                review.setRating(rs.getFloat("rating"));
                review.setContent(rs.getString("content"));
                review.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                reviews.add(review);
            }
        }
        return reviews;
    }

    public List<Review> selectByCustomerId(String customerId, Connection connection) throws Exception {
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_REVIEW_BY_CUSTOMER_ID)) {
            ps.setString(1, customerId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getInt("review_id"));
                review.setProductId(rs.getInt("product_id"));
                review.setCustomerId(rs.getString("customer_id"));
                review.setRating(rs.getFloat("rating"));
                review.setContent(rs.getString("content"));
                review.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                reviews.add(review);
            }
        }
        return reviews;
    }
}
