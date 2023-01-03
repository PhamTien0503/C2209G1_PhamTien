<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03-01-23
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<form action="/product">
    <h1>LIST PRODUCT</h1>
    <input type="text" name="idFind" value="id">
    <button type="submit" name="action" value="find">FIND PRODUCT</button>
    <br>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Cost</th>
            <th scope="col">Description</th>
            <th scope="col">Producer</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
            <th scope="col">View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.cost}</td>
                <td>${product.description}</td>
                <td>${product.producer}</td>
                <td>
                    <button type="submit" class="btn btn-outline-primary">
                        <a href="/product?action=update&id=${product.getId()}">Update</a></button>
                </td>
                <td>
                    <button type="submit" class="btn btn-outline-danger">
                        <a href="/product?action=remove&id=${product.getId()}">Remove</a></button>
                </td>
                <td>
                    <button type="submit" class="btn btn-outline-warning">
                        <a href="/product?action=view&id=${product.getId()}">View</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="submit" name="action" value="create">ADD NEW PRODUCT</button>
    <br>
</form>
</body>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.js">
</html>
