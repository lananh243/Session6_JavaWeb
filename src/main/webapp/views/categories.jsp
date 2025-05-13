<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/12/2025
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h3>List Categories</h3>
<table border="1">
    <thead>
    <th>No</th>
    <th>Catalog Id</th>
    <th>Catalog Name</th>
    <th>Descriptions</th>
    <th>Status</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${listCategories}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.catalogId}</td>
            <td>${item.catalogName}</td>
            <td>${item.description}</td>
            <td>${item.status}</td>
            <td>
                <a href="<%=request.getContextPath()%>/CategoriesController?catalogId=${item.catalogId}&&action=initUpdate">Update</a>
                <a href="<%=request.getContextPath()%>/CategoriesController?catalogId=${item.catalogId}&&action=delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="views/newCatalog.jsp">Create new catalog</a>
</body>
</html>
