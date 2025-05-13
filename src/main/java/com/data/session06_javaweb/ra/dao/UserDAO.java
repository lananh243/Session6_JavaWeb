package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    User getUser(String username, String password);
}
