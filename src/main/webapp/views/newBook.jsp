<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/12/2025
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
</head>
<body>
  <h3>Create Book</h3>
  <form action="<%=request.getContextPath()%>/books?action=Create" method="post">
      <label for="title">Tên sách</label>
      <input type="text" name="title" id="title"><br>
      <label for="author">Tác giả</label>
      <input type="text" name="author" id="author"><br>
      <label for="category">Thể loại</label>
      <input type="text" name="category" id="category"><br>
      <label for="quantity">Số lượng</label>
      <input type="number" name="quantity" id="quantity"><br>
      <input type="submit" value="Create">
  </form>
</body>
</html>
