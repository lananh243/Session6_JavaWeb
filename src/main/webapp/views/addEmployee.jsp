<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/13/2025
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Nhân Viên</title>
</head>
<body>
    <h3>Thêm Nhân Viên</h3>
    <form action="<%=request.getContextPath()%>/employees?action=Create" method="post">
        <label for="name">Tên:</label>
        <input type="text" id="name" name="name" required/><br/><br/>

        <label for="birthday">Ngày Sinh:</label>
        <input type="date" id="birthday" name="birthday" required/><br/><br/>

        <label for="phone">Điện Thoại:</label>
        <input type="text" id="phone" name="phone" required/><br/><br/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/><br/><br/>

        <label for="salary">Lương:</label>
        <input type="number" id="salary" name="salary" required/><br/><br/>

        <label for="position">Chức Vụ:</label>
        <input type="text" id="position" name="position" required/><br/><br/>

        <input type="submit" value="Thêm Nhân Viên"/>
    </form>
</body>
</html>
