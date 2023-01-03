<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03-01-23
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/css/bootstrap.css">
    <style>
        form {
            margin: 0 auto;
            height: 500px;
            width: 800px;
        }

        label {
            margin: 5px;
        }

        input {
            margin: 5px;
        }

    </style>
</head>
<body>
<form action="/product" method="post">
    <h1>ADD NEW PRODUCT </h1>
    <a href="/product">Comeback product list</a>
    <p style="color: red">${mess}</p>
    <label> Id</label>
    <input type="number" name="id"><br>
    <lable>Name</lable>
    <input type="text" name="name"><br>
    <lable>Cost</lable>
    <input type="number" name="cost"><br>
    <lable>Description</lable>
    <input type="text" name="description"><br>
    <lable>Producer</lable>
    <input type="text" name="producer"><br>
    <button class="btn btn-danger" type="submit " name="action" value="create">SAVE</button>
</form>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.js">
</body>
</html>
