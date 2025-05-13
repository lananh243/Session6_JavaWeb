<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/12/2025
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
  <h3>Danh sách sách</h3>
  <form method="get" action="books">
    <input type="hidden" name="action" value="search">
    <input type="text" name="valueTitle" placeholder="Nhập tên sách...">
    <button type="submit">Tìm kiếm</button>
  </form>

  <table border="1">
    <thead>
      <tr>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Thể loại</th>
        <th>Số lượng</th>
        <th>Hành động</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBooks}" var="item">
      <tr>
        <td>${item.bookId}</td>
        <td>${item.title}</td>
        <td>${item.author}</td>
        <td>${item.category}</td>
        <td>${item.quantity}</td>
        <td>
          <a href="<%=request.getContextPath()%>/books?bookId=${item.bookId}&&action=update">Update</a>
          <a href="<%=request.getContextPath()%>/books?bookId=${item.bookId}&&action=delete">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

<a href="views/newBook.jsp">Create new book</a>
</body>
</html>
