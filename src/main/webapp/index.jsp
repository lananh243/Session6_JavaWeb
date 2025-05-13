<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%response.sendRedirect("CategoriesController?action=findAll");%>

<%response.sendRedirect("books?action=getAll");%>

<%
    response.sendRedirect("products?action=findAll");
%>

<%
    response.sendRedirect("employees?action=getAll");
%>
</body>
</html>