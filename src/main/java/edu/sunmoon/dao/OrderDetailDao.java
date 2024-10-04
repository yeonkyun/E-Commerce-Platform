package edu.sunmoon.dao;

import edu.sunmoon.dto.OrderDetail;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao implements DAO<Integer, OrderDetail> {

    @Override
    public OrderDetail insert(OrderDetail orderDetail, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_ORDER_DETAIL)) {
            ps.setInt(1, orderDetail.getOrderId());
            ps.setInt(2, orderDetail.getProductId());
            ps.setInt(3, orderDetail.getPrice());
            ps.setInt(4, orderDetail.getDiscountPrice());
            ps.setInt(5, orderDetail.getQuantity());
            ps.executeUpdate();
        }
        return orderDetail;
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_ORDER_DETAIL)) {
            ps.setInt(1, orderDetail.getPrice());
            ps.setInt(2, orderDetail.getDiscountPrice());
            ps.setInt(3, orderDetail.getQuantity());
            ps.setInt(4, orderDetail.getId());
            ps.executeUpdate();
        }
        return orderDetail;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_ORDER_DETAIL)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public OrderDetail select(Integer integer, Connection connection) throws Exception {
        OrderDetail orderDetail = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ORDER_DETAIL_BY_ID)) {
            ps.setInt(1, integer);
            var rs = ps.executeQuery();
            if (rs.next()) {
                orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt("order_detail_id"));
                orderDetail.setOrderId(rs.getInt("order_id"));
                orderDetail.setProductId(rs.getInt("product_id"));
                orderDetail.setPrice(rs.getInt("product_price"));
                orderDetail.setDiscountPrice(rs.getInt("total_discount_price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
            }
        }
        return orderDetail;
    }

    @Override
    public List<OrderDetail> select(Connection connection) throws Exception {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ORDER_DETAIL)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                var orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt("order_detail_id"));
                orderDetail.setOrderId(rs.getInt("order_id"));
                orderDetail.setProductId(rs.getInt("product_id"));
                orderDetail.setPrice(rs.getInt("product_price"));
                orderDetail.setDiscountPrice(rs.getInt("total_discount_price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetails.add(orderDetail);
            }
        }
        return orderDetails;
    }

    public List<OrderDetail> selectByOrderId(Integer orderId, Connection connection) throws Exception {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ORDER_DETAIL_BY_ORDER_ID)) {
            ps.setInt(1, orderId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt("order_detail_id"));
                orderDetail.setOrderId(rs.getInt("order_id"));
                orderDetail.setProductId(rs.getInt("product_id"));
                orderDetail.setPrice(rs.getInt("product_price"));
                orderDetail.setDiscountPrice(rs.getInt("total_discount_price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetails.add(orderDetail);
            }
        }
        return orderDetails;
    }
}
