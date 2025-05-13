package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.dao.UserDAO;
import com.data.session06_javaweb.ra.dao.UserDAOImp;
import com.data.session06_javaweb.ra.model.User;

public class UserServiceImp implements UserService {
    private final UserDAO userDAO;

    public UserServiceImp() {
        userDAO = new UserDAOImp();
    }


    @Override
    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public User getUser(String username, String password) {
        return userDAO.getUser(username, password);
    }
}
