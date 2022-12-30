<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30-12-22
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
    <title>List Customer</title>
</head>
<body>
    <table class="table table-dark">
        <tr>
            <th>Name</th>
            <th>Day of Birth</th>
            <th>Address</th>
            <th>Image</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" >
            <tr>
                <td>${customer.name}</td>
                <td>${customer.dayOfBirth}</td>
                <td>${customer.address}</td>
                <td><img src="${customer.img}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
