package services;

import dao.TaskDAO;
import entities.Task;
import java.util.Vector;

public class TaskService {

    private TaskDAO dao = new TaskDAO();

    public boolean addTask(int userId, String description) {
        return dao.create(new Task(userId, description));
    }

    public Vector<Task> listTasks(int userId) {
        return dao.listByUser(userId);
    }
}
