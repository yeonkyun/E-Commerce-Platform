package edu.sunmoon.dao;

import edu.sunmoon.dto.CouponBox;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CouponBoxDao implements DAO<Integer, CouponBox> {

    @Override
    public CouponBox insert(CouponBox couponBox, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_COUPON_BOX)) {
            ps.setString(1, couponBox.getCustomerId());
            ps.setInt(2, couponBox.getCouponId());
            ps.setBoolean(3, couponBox.isUsed());
            ps.executeUpdate();
        }
        return couponBox;
    }

    @Override
    public CouponBox update(CouponBox couponBox, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_COUPON_BOX)) {
            ps.setBoolean(1, couponBox.isUsed());
            ps.setInt(2, couponBox.getId());
            ps.executeUpdate();
        }
        return couponBox;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_COUPON_BOX)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public CouponBox select(Integer integer, Connection connection) throws Exception {
        CouponBox couponBox = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_COUPON_BOX_BY_ID)) {
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                couponBox = new CouponBox();
                couponBox.setId(rs.getInt("coupon_box_id"));
                couponBox.setCustomerId(rs.getString("customer_id"));
                couponBox.setCouponId(rs.getInt("coupon_id"));
                couponBox.setUsed(rs.getBoolean("is_used"));
            }
        }
        return couponBox;
    }

    @Override
    public List<CouponBox> select(Connection connection) throws Exception {
        List<CouponBox> couponBoxes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_COUPON_BOX)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CouponBox couponBox = new CouponBox();
                couponBox.setId(rs.getInt("coupon_box_id"));
                couponBox.setCustomerId(rs.getString("customer_id"));
                couponBox.setCouponId(rs.getInt("coupon_id"));
                couponBox.setUsed(rs.getBoolean("is_used"));
                couponBoxes.add(couponBox);
            }
        }
        return couponBoxes;
    }

    public List<CouponBox> selectByCustomerId(String customerId, Connection connection) throws Exception {
        List<CouponBox> couponBoxes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_COUPON_BOX_BY_CUSTOMER_ID)) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CouponBox couponBox = new CouponBox();
                couponBox.setId(rs.getInt("coupon_box_id"));
                couponBox.setCustomerId(rs.getString("customer_id"));
                couponBox.setCouponId(rs.getInt("coupon_id"));
                couponBox.setUsed(rs.getBoolean("is_used"));
                couponBoxes.add(couponBox);
            }
        }
        return couponBoxes;
    }

    public List<CouponBox> selectByCouponId(String couponId, Connection connection) throws Exception {
        List<CouponBox> couponBoxes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_COUPON_BOX_BY_COUPON_ID)) {
            ps.setString(1, couponId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CouponBox couponBox = new CouponBox();
                couponBox.setId(rs.getInt("coupon_box_id"));
                couponBox.setCustomerId(rs.getString("customer_id"));
                couponBox.setCouponId(rs.getInt("coupon_id"));
                couponBox.setUsed(rs.getBoolean("is_used"));
                couponBoxes.add(couponBox);
            }
        }
        return couponBoxes;
    }
}