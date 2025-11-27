package services;

import dao.UserDAO;
import entities.User;

public class UserService {

    private UserDAO dao = new UserDAO();

    public boolean register(String username, String password) {
        if (dao.findByUsername(username) != null) {
            return false;
        }
        return dao.create(new User(username, password));
    }

    public User login(String username, String password) {
        User user = dao.findByUsername(username);

        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;

        return user;
    }
}
