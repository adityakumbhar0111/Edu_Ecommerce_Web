package dao;

import model.User;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserDAO {
    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] b = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte x : b) sb.append(String.format("%02x", x));
            return sb.toString();
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public User findByEmail(String email) {
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE email=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password_hash"), rs.getString("fullname"));
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public User create(String email, String password, String fullname) {
        String hashed = hash(password);
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO users(email,password_hash,fullname) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, email);
            ps.setString(2, hashed);
            ps.setString(3, fullname);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return new User(keys.getInt(1), email, hashed, fullname);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public boolean checkPassword(User user, String password) {
        if (user == null) return false;
        return user.getPasswordHash().equals(hash(password));
    }
}
