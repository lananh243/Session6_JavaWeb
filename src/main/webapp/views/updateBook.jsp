<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/12/2025
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
    <h3>Cập nhật Sách</h3>
    <form action="<%=request.getContextPath()%>/books?action=Update" method="post">
        <label for="bookId">Mã sách</label>
        <input type="number" name="bookId" id="bookId" value="${book.bookId}" readonly><br>
        <label for="title">Tên sách</label>
        <input type="text" name="title" id="title" value="${book.title}"><br>
        <label for="author">Tác giả</label>
        <input type="text" name="author" id="author" value="${book.author}"><br>
        <label for="category">Thể loại</label>
        <input type="text" name="category" id="category" value="${book.category}"><br>
        <label for="quantity">Số lượng</label>
        <input type="number" name="quantity" id="quantity" value="${book.quantity}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
