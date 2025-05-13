package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int page, int size);
    int getTotalEmployees();
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    boolean deleteEmployee(int employeeId);
    List<Employee> searchEmployeeByName(String employeeName);
}
