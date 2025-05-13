package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.dao.EmployeeDAO;
import com.data.session06_javaweb.ra.dao.EmployeeDAOImp;
import com.data.session06_javaweb.ra.model.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImp() {
        employeeDAO = new EmployeeDAOImp();
    }


    @Override
    public List<Employee> getEmployees(int page, int size) {
        return employeeDAO.getEmployees(page, size);
    }

    @Override
    public int getTotalEmployees() {
        return employeeDAO.getTotalEmployees();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }

    @Override
    public List<Employee> searchEmployeeByName(String employeeName) {
        return employeeDAO.searchEmployeeByName(employeeName);
    }
}
