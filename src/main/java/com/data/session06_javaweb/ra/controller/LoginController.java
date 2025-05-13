package com.data.session06_javaweb.ra.controller;

import com.data.session06_javaweb.ra.model.User;
import com.data.session06_javaweb.ra.service.UserService;
import com.data.session06_javaweb.ra.service.UserServiceImp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private final UserService userService;

    public LoginController() {
        userService = new UserServiceImp();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUserName());
            response.sendRedirect(request.getContextPath() + "/books?action=getAll");
        } else {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}