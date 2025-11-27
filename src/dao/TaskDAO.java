package dao;

import entities.Task;
import java.sql.*;
import java.util.Vector;

public class TaskDAO {

    public boolean create(Task task) {
        String sql = "INSERT INTO tasks (user_id, description) VALUES (?, ?)";


        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1, task.getUserId());
            stmt.setString(2, task.getDescription());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public Vector<Task> listByUser(int userId) {
        Vector<Task> tasks = new Vector<>();
        String sql = "SELECT * FROM tasks WHERE user_id = ?";


        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Task t = new Task(rs.getInt("user_id"),rs.getString("description"));
                t.setId(rs.getInt("id"));
                tasks.add(t);
            }
        } catch (Exception e) {
            return tasks;
        }

        return tasks;
    }
}
