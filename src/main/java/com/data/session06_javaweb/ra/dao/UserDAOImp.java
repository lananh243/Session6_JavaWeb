package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.User;
import com.data.session06_javaweb.ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class UserDAOImp implements UserDAO {

    @Override
    public boolean addUser(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call register_user(?,?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getPassword());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getPhone());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public User getUser(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call login_user(?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("user_password"));
                user.setEmail(rs.getString("user_email"));
                user.setPhone(rs.getString("user_phone"));
            }

        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }
}
