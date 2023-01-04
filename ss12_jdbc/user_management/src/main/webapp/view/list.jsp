<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04-01-23
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>LIST USER</h1>
<button type="submit" class="btn-outline-info m-2"><a href="/User?action=add">ADD NEW USER</a></button><br>
<button type="submit" class="btn-outline-warning m-2"><a href="/User?action=sort">SORT BY NAME</a></button><br>
<form action="/User">
<input type="text" name="country" value="country">
<button type="submit" class="btn-outline-success m-2" name="action" value="search"><a>SEARCH USER</a></button><br>
</form>
<table class="table table-active">
    <tr class="table-dark">
        <td>ID</td>
        <td>Name User</td>
        <td>Email</td>
        <td>Country</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><button><a href="/User?action=edit&id=${user.id}">edit</a></button></td>
            <td><button><a href="/User?action=delete&id=${user.id}">delete</a></button></td>

        </tr>
    </c:forEach>
</table>
<a href="/User?action=select"><h3>List user</h3></a>
</body>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.js">
</html>
