<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/13/2025
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Nhân Viên</title>
</head>
<body>
    <h3>Danh Sách Nhân Viên</h3>
    <a href="views/addEmployee.jsp">Create new employee</a>
    <br><br>
    <form method="get" action="employees">
        <input type="hidden" name="action" value="search">
        <input type="text" name="searchName" placeholder="Nhập tên nhân viên...">
        <button type="submit">Tìm kiếm</button>
    </form>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Điện Thoại</th>
            <th>Email</th>
            <th>Lương</th>
            <th>Chức Vụ</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listEmployees}" var="employee">
            <tr>
                <td>${employee.employee_id}</td>
                <td>${employee.name}</td>
                <td>${employee.birthday}</td>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <td>${employee.salary}</td>
                <td>${employee.position}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/employees?employeeId=${employee.employee_id}&&action=update">Update</a>
                    <a href="<%=request.getContextPath()%>/employees?employeeId=${employee.employee_id}&&action=delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br><br>
    <div class="flex justify-between items-center mt-4">
        <c:if test="${page > 1}">
            <a href="?action=getAll&page=${page - 1}" class="btn">Trước</a>
        </c:if>

        <span>
        Trang ${page} / ${totalPages}
    </span>

        <c:if test="${page < totalPages}">
            <a href="?action=getAll&page=${page + 1}" class="btn">Tiếp</a>
        </c:if>
    </div>
</body>
</html>
