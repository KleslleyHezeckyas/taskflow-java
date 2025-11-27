package dao;

import entities.User;
import java.sql.*;
import java.util.Vector;

public class UserDAO {

    public boolean create(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User u = new User(rs.getString("username"), rs.getString("password"));
                u.setId(rs.getInt("id"));
                return u;
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public Vector<User> listAll() {
        Vector<User> users = new Vector<>();

        String sql = "SELECT * FROM users";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User u = new User(rs.getString("username"), rs.getString("password"));
                u.setId(rs.getInt("id"));
                users.add(u);
            }

        } catch (Exception e) {
            return users;
        }

        return users;
    }
}
