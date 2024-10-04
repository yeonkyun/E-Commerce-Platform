package edu.sunmoon.dao;

import edu.sunmoon.dto.Category;
import edu.sunmoon.frame.DAO;
import edu.sunmoon.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements DAO<Integer, Category> {
    @Override
    public Category insert(Category category, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.INSERT_CATEGORY)) {
            ps.setInt(1, category.getId());
            ps.setInt(2, category.getParentsId());
            ps.setString(3, category.getName());
            ps.executeUpdate();
        }
        return category;
    }

    @Override
    public Category update(Category category, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.UPDATE_CATEGORY)) {
            ps.setInt(1, category.getParentsId());
            ps.setString(2, category.getName());
            ps.setInt(3, category.getId());
            ps.executeUpdate();
        }
        return category;
    }

    @Override
    public Boolean delete(Integer integer, Connection connection) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(SQL.DELETE_CATEGORY)) {
            ps.setInt(1, integer);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Category select(Integer integer, Connection connection) throws Exception {
        Category category = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CATEGORY_BY_ID)) {
            ps.setInt(1, integer);
            var rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setParentsId(rs.getInt("parents_id"));
                category.setName(rs.getString("name"));
            }
        }
        return category;
    }

    @Override
    public List<Category> select(Connection connection) throws Exception {
        var categories = new ArrayList<Category>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CATEGORY)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                var category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setParentsId(rs.getInt("parents_id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        }
        return categories;
    }

    public Category selectByName(String name, Connection connection) throws Exception {
        Category category = null;
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CATEGORY_BY_NAME)) {
            ps.setString(1, name);
            var rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setParentsId(rs.getInt("parents_id"));
                category.setName(rs.getString("name"));
            }
        }
        return category;
    }

    public List<Category> selectByParentsId(Integer parentsId, Connection connection) throws Exception {
        var categories = new ArrayList<Category>();
        try (PreparedStatement ps = connection.prepareStatement(SQL.SELECT_CATEGORY_BY_PARENTS_ID)) {
            ps.setInt(1, parentsId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setParentsId(rs.getInt("parents_id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        }
        return categories;
    }
}
