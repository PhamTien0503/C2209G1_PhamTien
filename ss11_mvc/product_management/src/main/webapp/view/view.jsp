<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03-01-23
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View detail product</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<h1>DETAIL PRODUCT</h1>
<a href="/product">Comeback product list</a>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Cost</th>
        <th scope="col">Description</th>
        <th scope="col">Producer</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.cost}</td>
        <td>${product.description}</td>
        <td>${product.producer}</td>
    </tr>
    </tbody>
</table>
</body>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.js">
</html>
