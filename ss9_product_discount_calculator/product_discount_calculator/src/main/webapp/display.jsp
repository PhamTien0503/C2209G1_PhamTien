<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
    <style>
        .view {
            background-color: darkcyan;
            margin: 0 auto;
            width: 300px;
            border: solid black;
        }

        .data input {
            float: left;
            width: 22em;
            height: 1em;
        }
    </style>
</head>
<body>
<div class="view">
    <h2> Product Discount Calculator</h2>
    <form action="/display-discount" method="post">
        <div class="data">
            <label> Product Description: </label> <br>
            <input type="text" name="description"> <br>
            <label> List Price: </label> <br>
            <input type="number" name="price"> <br>
            <label> Discount Percent: </label><br>
            <input type="number" name="discount"> <br>
            <button type="submit"> Calculator Discount</button>
        </div>
    </form>
</div>
</body>
</html>