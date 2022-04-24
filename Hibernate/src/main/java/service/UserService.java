package service;

import dao.UserDAO;
import model.User;

public class UserService {
    private UserDAO userDAO;
    public UserService() {
        userDAO = new UserDAO();
    }
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void update(User user) {
        userDAO.updateUser(user);
    }
    public void addUser(String username, String password, String email, String phone,
                        String role, String status, String address, String fullname, String birthday) {
        User newUser = new User(username, password, email, phone, role, status, address, fullname, birthday);
        userDAO.addUser(newUser);
    }
    public User signIn(String username, String password, String role) {
        return userDAO.signIn(username, password, role);
    }
}
