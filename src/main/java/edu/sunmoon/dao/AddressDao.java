package edu.sunmoon.dao;

import edu.sunmoon.dto.Address;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements DAO<Integer, Address> {
    @Override
    public Address insert(Address address, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_ADDRESS)) {
            ps.setString(1, address.getCustomerId());
            ps.setString(2, address.getType());
            ps.setString(3, address.getName());
            ps.setString(4, address.getPhone());
            ps.setString(5, address.getAddress1());
            ps.setString(6, address.getAddress2());
            ps.setString(7, address.getZipCode());
            ps.setBoolean(8, address.isDefault());
            ps.executeUpdate();
        }
        return address;
    }

    @Override
    public Address update(Address address, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_ADDRESS)) {
            ps.setString(1, address.getType());
            ps.setString(2, address.getName());
            ps.setString(3, address.getPhone());
            ps.setString(4, address.getAddress1());
            ps.setString(5, address.getAddress2());
            ps.setString(6, address.getZipCode());
            ps.setBoolean(7, address.isDefault());
            ps.setInt(8, address.getId());
            ps.executeUpdate();
        }
        return address;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_ADDRESS)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Address select(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ADDRESS_BY_ID)) {
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            Address address = null;
            if (rs.next()) {
                address = new Address();
                address.setId(rs.getInt("address_id"));
                address.setCustomerId(rs.getString("customer_id"));
                address.setType(rs.getString("type"));
                address.setName(rs.getString("name"));
                address.setPhone(rs.getString("phone"));
                address.setAddress1(rs.getString("address1"));
                address.setAddress2(rs.getString("address2"));
                address.setZipCode(rs.getString("zip_code"));
                address.setDefault(rs.getBoolean("is_default"));
            }
            return address;
        }
    }

    @Override
    public List<Address> select(Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ADDRESS)) {
            ResultSet rs = ps.executeQuery();
            List<Address> addresses = new ArrayList<>();
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("address_id"));
                address.setCustomerId(rs.getString("customer_id"));
                address.setType(rs.getString("type"));
                address.setName(rs.getString("name"));
                address.setPhone(rs.getString("phone"));
                address.setAddress1(rs.getString("address1"));
                address.setAddress2(rs.getString("address2"));
                address.setZipCode(rs.getString("zip_code"));
                address.setDefault(rs.getBoolean("is_default"));
                addresses.add(address);
            }
            return addresses;
        }
    }

    public List<Address> selectByCustomerId(String customerId, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_ADDRESS_BY_CUSTOMER_ID)) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            List<Address> addresses = new ArrayList<>();
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("address_id"));
                address.setCustomerId(rs.getString("customer_id"));
                address.setType(rs.getString("type"));
                address.setName(rs.getString("name"));
                address.setPhone(rs.getString("phone"));
                address.setAddress1(rs.getString("address1"));
                address.setAddress2(rs.getString("address2"));
                address.setZipCode(rs.getString("zip_code"));
                address.setDefault(rs.getBoolean("is_default"));
                addresses.add(address);
            }
            return addresses;
        }
    }
}
