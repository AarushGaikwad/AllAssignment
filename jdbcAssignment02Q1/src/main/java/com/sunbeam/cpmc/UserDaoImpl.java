package com.sunbeam.cpmc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection con;

    public UserDaoImpl() throws Exception {
        con = DbUtil.connect();
    }

    @Override
    public void close() throws Exception {
        if (con != null)
            con.close();
    }

    @Override
    public User findById(int userId) throws Exception {
        String sql = "SELECT * FROM users WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String addr = rs.getString("addr");
                    String role = rs.getString("role");
                    Date birth = rs.getDate("birth");

                    return new User(userId, name, password, email, addr, role, birth);
                }
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() throws Exception {
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String addr = rs.getString("addr");
                String role = rs.getString("role");
                Date birth = rs.getDate("birth");

                list.add(new User(id, name, password, email, addr, role, birth));
            }
        }
        return list;
    }

    @Override
    public User findByEmail(String email) throws Exception {
        String sql = "SELECT * FROM users WHERE email=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    String addr = rs.getString("addr");
                    String role = rs.getString("role");
                    Date birth = rs.getDate("birth");

                    return new User(id, name, password, email, addr, role, birth);
                }
            }
        }
        return null;
    }

    @Override
    public int save(User user) throws Exception {
        String sql = "INSERT INTO users (name, password, email, addr, role, birth) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddr());
            stmt.setString(5, user.getRole());
            stmt.setDate(6, user.getBirth());

            return stmt.executeUpdate();
        }
    }

    @Override
    public int update(User user) throws Exception {
        String sql = "UPDATE users SET name=?, password=?, email=?, addr=?, role=?, birth=? WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddr());
            stmt.setString(5, user.getRole());
            stmt.setDate(6, user.getBirth());
            stmt.setInt(7, user.getId());

            return stmt.executeUpdate();
        }
    }

    @Override
    public int changePassword(int userId, String newPassword) throws Exception {
        String sql = "UPDATE users SET password=? WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, userId);

            return stmt.executeUpdate();
        }
    }

    @Override
    public int deleteById(int userId) throws Exception {
        String sql = "DELETE FROM users WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            return stmt.executeUpdate();
        }
    }
}