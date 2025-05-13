package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.model.User;

public interface UserService {
    boolean addUser(User user);
    User getUser(String username, String password);
}
