<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/13/2025
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
    <h3>Danh sách sản phẩm</h3>
    <c:if test="${not empty message}">
        <p style="color: green;">${message}</p>
    </c:if>
    <table border="1">
        <thead>
            <tr>
                <th>Mã sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Giá</th>
                <th>Ảnh</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listProducts}" var="item">
                <tr>
                    <td>${item.productId}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.imageUrl}</td>
                    <td>
                        <form action="<%=request.getContextPath()%>/products?action=Add" method="post">
                            <input type="hidden" name="productId" value="${item.productId}">
                            <input type="hidden" name="userId" value="1">
                            <input type="hidden" name="quantity" value="1" required>
                            <button type="submit">Thêm vào giỏ hàng</button>
                        </form>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
