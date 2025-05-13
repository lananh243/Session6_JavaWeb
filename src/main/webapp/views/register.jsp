<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/13/2025
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="container mx-auto max-w-md mt-20 p-6 bg-white rounded-lg shadow-md">
  <h2 class="text-2xl font-bold mb-6 text-center">Register</h2>
  <form action="<%=request.getContextPath()%>/register" method="post">
    <div class="mb-4">
      <label for="username" class="block text-sm font-medium text-gray-700">Username:</label>
      <input type="text" id="username" name="username" required class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
    </div>
    <div class="mb-4">
      <label for="password" class="block text-sm font-medium text-gray-700">Password:</label>
      <input type="password" id="password" name="password" required class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
    </div>
    <div class="mb-4">
      <label for="email" class="block text-sm font-medium text-gray-700">Email:</label>
      <input type="email" id="email" name="email" required class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
    </div>
    <div class="mb-4">
      <label for="phone" class="block text-sm font-medium text-gray-700">Phone:</label>
      <input type="text" id="phone" name="phone" required class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
    </div>
    <div class="mb-6">
      <button type="submit" class="w-full py-2 px-4 bg-blue-600 text-white font-semibold rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500">Register</button>
    </div>

  </form>
  <c:if test="${not empty error}">
    <div class="text-red-600 mb-4 text-center">${error}</div>
  </c:if>
  <p class="text-center mt-4">Đã có tài khoản? <a href="login.jsp" class="text-blue-600 hover:underline">Đăng nhập</a></p>
</div>
</body>
</html>
