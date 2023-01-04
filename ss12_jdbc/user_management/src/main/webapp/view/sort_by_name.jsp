<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04-01-23
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
<html>
<head>
    <title>List user sorted by name</title>
</head>
<body>
<h1>LIST USER SORTED BY NAME</h1>
<table class="table table-active">
    <tr class="table-dark">
        <td>ID</td>
        <td>Name User</td>
        <td>Email</td>
        <td>Country</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
        </tr>
    </c:forEach>
</table>
<a href="/User?action=select"><h3>Comeback list user</h3></a>
</body>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.js">
</html>