package edu.sunmoon.dao;

import edu.sunmoon.dto.UsedCoupon;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UsedCouponDao implements DAO<Integer, UsedCoupon> {

    @Override
    public UsedCoupon insert(UsedCoupon usedCoupon, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_USED_COUPON)) {
            ps.setInt(1, usedCoupon.getOrderDetailId());
            ps.setInt(2, usedCoupon.getCouponId());
            ps.setInt(3, usedCoupon.getCouponDiscountPrice());
            ps.executeUpdate();
        }
        return usedCoupon;
    }

    @Override
    public UsedCoupon update(UsedCoupon usedCoupon, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_USED_COUPON)) {
            ps.setInt(1, usedCoupon.getCouponId());
            ps.setInt(2, usedCoupon.getCouponDiscountPrice());
            ps.setInt(3, usedCoupon.getOrderDetailId());
            ps.executeUpdate();
        }
        return usedCoupon;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_USED_COUPON)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public UsedCoupon select(Integer integer, Connection connection) throws Exception {
        UsedCoupon usedCoupon = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_USED_COUPON_BY_ID)) {
            ps.setInt(1, integer);
            var rs = ps.executeQuery();
            if (rs.next()) {
                usedCoupon = new UsedCoupon();
                usedCoupon.setId(rs.getInt("used_coupon_id"));
                usedCoupon.setOrderDetailId(rs.getInt("order_detail_id"));
                usedCoupon.setCouponId(rs.getInt("coupon_id"));
                usedCoupon.setCouponDiscountPrice(rs.getInt("coupon_discount_price"));
                usedCoupon.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
        }
        return usedCoupon;
    }

    @Override
    public List<UsedCoupon> select(Connection connection) throws Exception {
        List<UsedCoupon> usedCoupons = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_USED_COUPON)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                UsedCoupon usedCoupon = new UsedCoupon();
                usedCoupon.setId(rs.getInt("used_coupon_id"));
                usedCoupon.setOrderDetailId(rs.getInt("order_detail_id"));
                usedCoupon.setCouponId(rs.getInt("coupon_id"));
                usedCoupon.setCouponDiscountPrice(rs.getInt("coupon_discount_price"));
                usedCoupon.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                usedCoupons.add(usedCoupon);
            }
        }
        return usedCoupons;
    }

    public List<UsedCoupon> selectByOrderDetailId(Integer orderDetailId, Connection connection) throws Exception {
        List<UsedCoupon> usedCoupons = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_USED_COUPON_BY_ORDER_DETAIL_ID)) {
            ps.setInt(1, orderDetailId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                UsedCoupon usedCoupon = new UsedCoupon();
                usedCoupon.setId(rs.getInt("used_coupon_id"));
                usedCoupon.setOrderDetailId(rs.getInt("order_detail_id"));
                usedCoupon.setCouponId(rs.getInt("coupon_id"));
                usedCoupon.setCouponDiscountPrice(rs.getInt("coupon_discount_price"));
                usedCoupon.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                usedCoupons.add(usedCoupon);
            }
        }
        return usedCoupons;
    }

    public List<UsedCoupon> selectByCouponId(Integer couponId, Connection connection) throws Exception {
        List<UsedCoupon> usedCoupons = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_USED_COUPON_BY_COUPON_ID)) {
            ps.setInt(1, couponId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                UsedCoupon usedCoupon = new UsedCoupon();
                usedCoupon.setId(rs.getInt("used_coupon_id"));
                usedCoupon.setOrderDetailId(rs.getInt("order_detail_id"));
                usedCoupon.setCouponId(rs.getInt("coupon_id"));
                usedCoupon.setCouponDiscountPrice(rs.getInt("coupon_discount_price"));
                usedCoupon.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                usedCoupons.add(usedCoupon);
            }
        }
        return usedCoupons;
    }
}
