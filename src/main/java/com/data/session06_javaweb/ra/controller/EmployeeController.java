package com.data.session06_javaweb.ra.controller;

import com.data.session06_javaweb.ra.model.Employee;
import com.data.session06_javaweb.ra.service.EmployeeService;
import com.data.session06_javaweb.ra.service.EmployeeServiceImp;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "/employees")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeServiceImp();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action.equals("getAll")) {
            findAllEmployee(request, response);
        }else if (action.equals("update")) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("views/updateEmployee.jsp").forward(request, response);
            }
        } else if (action.equals("delete")) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            boolean result = employeeService.deleteEmployee(employeeId);
            if (result) {
                findAllEmployee(request, response);
            }
        } else if (action.equals("search")) {
            String searchName = request.getParameter("searchName");
            List<Employee> listEmployees = employeeService.searchEmployeeByName(searchName);
            request.setAttribute("listEmployees", listEmployees);
            request.getRequestDispatcher("views/employeeList.jsp").forward(request, response);
        }
    }

    public void findAllEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int page = 1;
        int size = 5;

        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
        }

        List<Employee> listEmployees = employeeService.getEmployees(page, size);
        request.setAttribute("listEmployees", listEmployees);
        int totalEmployees = employeeService.getTotalEmployees();
        int totalPages = (int) Math.ceil((double) totalEmployees / size);

        request.setAttribute("listEmployees",listEmployees);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("page", page);
        request.getRequestDispatcher("views/employeeList.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Employee employee = new Employee();
            employee.setName(request.getParameter("name"));
            employee.setBirthday(LocalDate.parse(request.getParameter("birthday")));
            employee.setPhone(request.getParameter("phone"));
            employee.setEmail(request.getParameter("email"));
            employee.setSalary(Double.parseDouble(request.getParameter("salary")));
            employee.setPosition(request.getParameter("position"));
            boolean result = employeeService.addEmployee(employee);
            if (result) {
                findAllEmployee(request, response);
            }

        } else if (action.equals("Update")) {
            Employee employee = new Employee();
            employee.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
            employee.setName(request.getParameter("name"));
            employee.setBirthday(LocalDate.parse(request.getParameter("birthday")));
            employee.setPhone(request.getParameter("phone"));
            employee.setEmail(request.getParameter("email"));
            String salaryParam = request.getParameter("salary");
            if (salaryParam != null && !salaryParam.isEmpty()) {
                employee.setSalary(Double.parseDouble(salaryParam));
            }
            employee.setPosition(request.getParameter("position"));
            boolean result = employeeService.updateEmployee(employee);
            if (result) {
                findAllEmployee(request, response);
            }
        }
    }
}