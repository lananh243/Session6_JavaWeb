package com.data.session06_javaweb.ra.controller;

import com.data.session06_javaweb.ra.model.User;
import com.data.session06_javaweb.ra.service.UserService;
import com.data.session06_javaweb.ra.service.UserServiceImp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private final UserService userService;

    public RegisterController() {
        userService = new UserServiceImp();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/register.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        boolean result = userService.addUser(user);
        if (result) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("error", "Tài khoản đã tồn tại");
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
        }
    }
}