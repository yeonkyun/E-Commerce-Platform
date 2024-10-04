package edu.sunmoon.dao;

import edu.sunmoon.dto.Coupon;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CouponDao implements DAO<String, Coupon> {
    @Override
    public Coupon insert(Coupon coupon, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_COUPON)) {
            ps.setString(1, coupon.getName());
            ps.setString(2, coupon.getCode());
            ps.setString(3, coupon.getType());
            ps.setInt(4, coupon.getDiscount());
            ps.setInt(5, coupon.getMinOrderPrice());
            ps.setInt(6, coupon.getMaxDiscountPrice());
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(coupon.getStartDate()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(coupon.getEndDate()));
            ps.setBoolean(9, coupon.isActive());
            ps.executeUpdate();
            return coupon;
        }
    }

    @Override
    public Coupon update(Coupon coupon, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_COUPON)) {
            ps.setString(1, coupon.getName());
            ps.setString(2, coupon.getCode());
            ps.setString(3, coupon.getType());
            ps.setInt(4, coupon.getDiscount());
            ps.setInt(5, coupon.getMinOrderPrice());
            ps.setInt(6, coupon.getMaxDiscountPrice());
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(coupon.getStartDate()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(coupon.getEndDate()));
            ps.setString(9, coupon.getCode());
            ps.executeUpdate();
            return coupon;
        }
    }

    @Override
    public Boolean delete(String s, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_COUPON)) {
            ps.setString(1, s);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Coupon select(String s, Connection connection) throws Exception {
        Coupon coupon = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_COUPON_BY_CODE)) {
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                coupon = new Coupon();
                coupon.setId(rs.getInt("coupon_id"));
                coupon.setName(rs.getString("name"));
                coupon.setCode(rs.getString("code"));
                coupon.setType(rs.getString("type"));
                coupon.setDiscount(rs.getInt("discount"));
                coupon.setMinOrderPrice(rs.getInt("min_order_price"));
                coupon.setMaxDiscountPrice(rs.getInt("max_discount_price"));
                coupon.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
                coupon.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
                coupon.setActive(rs.getBoolean("is_active"));
                coupon.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
        }
        return coupon;
    }

    @Override
    public List<Coupon> select(Connection connection) throws Exception {
        List<Coupon> coupons = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_COUPON)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Coupon coupon = new Coupon();
                coupon.setId(rs.getInt("coupon_id"));
                coupon.setName(rs.getString("name"));
                coupon.setCode(rs.getString("code"));
                coupon.setType(rs.getString("type"));
                coupon.setDiscount(rs.getInt("discount"));
                coupon.setMinOrderPrice(rs.getInt("min_order_price"));
                coupon.setMaxDiscountPrice(rs.getInt("max_discount_price"));
                coupon.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
                coupon.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
                coupon.setActive(rs.getBoolean("is_active"));
                coupon.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                coupons.add(coupon);
            }
        }
        return coupons;
    }
}
