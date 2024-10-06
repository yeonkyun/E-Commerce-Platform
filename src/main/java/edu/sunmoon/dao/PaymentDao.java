package edu.sunmoon.dao;

import edu.sunmoon.dto.Payment;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao implements DAO<Integer, Payment> {

    @Override
    public Payment insert(Payment payment, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_PAYMENT)) {
            ps.setInt(1, payment.getOrderId());
            ps.setString(2, payment.getPaymentMethod());
            ps.setString(3, payment.getStatus());
            ps.setInt(4, payment.getOrderId());
            ps.executeUpdate();
        }
        return payment;
    }

    @Override
    public Payment update(Payment payment, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_PAYMENT)) {
            ps.setString(1, payment.getStatus());
            ps.setInt(2, payment.getId());
            ps.executeUpdate();
        }
        return payment;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_PAYMENT)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Payment select(Integer integer, Connection connection) throws Exception {
        Payment payment = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PAYMENT_BY_ID)) {
            ps.setInt(1, integer);
            var rs = ps.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setId(rs.getInt("payment_id"));
                payment.setOrderId(rs.getInt("order_id"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPrice(rs.getInt("price"));
                payment.setStatus(rs.getString("status"));
                payment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
        }
        return payment;
    }

    @Override
    public List<Payment> select(Connection connection) throws Exception {
        List<Payment> payments = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PAYMENT)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("payment_id"));
                payment.setOrderId(rs.getInt("order_id"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPrice(rs.getInt("price"));
                payment.setStatus(rs.getString("status"));
                payment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                payments.add(payment);
            }
        }
        return payments;
    }

    public List<Payment> selectByOrderId(Integer orderId, Connection connection) throws Exception {
        List<Payment> payments = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PAYMENT_BY_ORDER_ID)) {
            ps.setInt(1, orderId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("payment_id"));
                payment.setOrderId(rs.getInt("order_id"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPrice(rs.getInt("price"));
                payment.setStatus(rs.getString("status"));
                payment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                payments.add(payment);
            }
        }
        return payments;
    }

    public List<Payment> selectByPaymentMethod(String paymentMethod, Connection connection) throws Exception {
        List<Payment> payments = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_PAYMENT_BY_PAYMENT_METHOD)) {
            ps.setString(1, paymentMethod);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("payment_id"));
                payment.setOrderId(rs.getInt("order_id"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setPrice(rs.getInt("price"));
                payment.setStatus(rs.getString("status"));
                payment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                payments.add(payment);
            }
        }
        return payments;
    }
}
