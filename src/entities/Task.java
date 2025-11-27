package entities;

public class Task {
    private int id;
    private int userId;
    private String description;

    public Task() {}

    public Task(int userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
