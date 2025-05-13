package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.Employee;
import com.data.session06_javaweb.ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    @Override
    public List<Employee> getEmployees(int page, int size) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_employee(?,?)}");
            callSt.setInt(1, page);
            callSt.setInt(2, size);
            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setBirthday(rs.getDate("employee_birthday").toLocalDate());
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setSalary(rs.getDouble("employee_salary"));
                employee.setPosition(rs.getString("employee_position"));
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public int getTotalEmployees() {
        Connection conn = null;
        CallableStatement callSt = null;
        int total = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_total_employee(?)}");
            callSt.registerOutParameter(1, Types.INTEGER);
            callSt.execute();
            total = callSt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return total;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_employee(?,?,?,?,?,?)}");
            callSt.setString(1, employee.getName());
            callSt.setString(2, String.valueOf(employee.getBirthday()));
            callSt.setString(3, employee.getPhone());
            callSt.setString(4, employee.getEmail());
            callSt.setDouble(5, employee.getSalary());
            callSt.setString(6, employee.getPosition());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_employee(?,?,?,?,?,?,?)}");
            callSt.setInt(1,  employee.getEmployee_id());
            callSt.setString(2, employee.getName());
            callSt.setString(3, String.valueOf(employee.getBirthday()));
            callSt.setString(4, employee.getPhone());
            callSt.setString(5, employee.getEmail());
            callSt.setDouble(6, employee.getSalary());
            callSt.setString(7, employee.getPosition());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_employee_by_id(?)}");
            callSt.setInt(1, employeeId);
            ResultSet rs = callSt.executeQuery();
            employee = new Employee();
            if (rs.next()) {
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setBirthday(rs.getDate("employee_birthday").toLocalDate());
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setSalary(rs.getDouble("employee_salary"));
                employee.setPosition(rs.getString("employee_position"));

            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_employee(?)}");
            callSt.setInt(1, employeeId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public List<Employee> searchEmployeeByName(String employeeName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_by_name(?)}");
            callSt.setString(1, employeeName);
            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setBirthday(rs.getDate("employee_birthday").toLocalDate());
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setSalary(rs.getDouble("employee_salary"));
                employee.setPosition(rs.getString("employee_position"));
                employees.add(employee);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }
}
