<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/13/2025
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập Nhật Nhân Viên</title>
</head>
<body>
<h3>Cập Nhật Thông Tin Nhân Viên</h3>

<form action="<%=request.getContextPath()%>/employees?action=Update" method="post">
  <input type="hidden" name="employee_id" value="${employee.employee_id}"/>
  <label for="name">Tên:</label>
  <input type="text" id="name" name="name" value="${employee.name}" required/><br/><br/>

  <label for="birthday">Ngày Sinh:</label>
  <input type="date" id="birthday" name="birthday" value="${employee.birthday}" required/><br/><br/>

  <label for="phone">Điện Thoại:</label>
  <input type="text" id="phone" name="phone" value="${employee.phone}" required/><br/><br/>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${employee.email}" required/><br/><br/>

  <label for="salary">Lương:</label>
  <input type="number" id="salary" name="salary" value="${employee.salary}" required/><br/><br/>

  <label for="position">Chức Vụ:</label>
  <input type="text" id="position" name="position" value="${employee.position}" required/><br/><br/>

  <input type="submit" value="Cập Nhật"/>
</form>
</body>
</html>
