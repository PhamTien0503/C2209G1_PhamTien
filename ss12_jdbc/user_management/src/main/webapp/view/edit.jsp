<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04-01-23
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1>EDIT USER</h1>
<h3 style="color: red">${mess}</h3>
<a href="/User">Come back list user page</a>
<form action="/User?id=${user.id}" method="post">
    <p>Name user</p>
    <input type="text" name="name" value="${user.name}"><br>
    <p>Email</p>
    <input type="text" name="email" value="${user.email}"><br>
    <p>Country</p>
    <input type="text" name="country" value="${user.country}"><br><br>
    <button type="submit" name="action" value="edit" >EDIT</button>
</form>
</body>
</html>

