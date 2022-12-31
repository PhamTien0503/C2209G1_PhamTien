<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <style>
        label{
            margin: 15px;
        }
        input {
            margin: 15px;
        }
        select {
            margin-left: 60px;
        }
        button {
            color: darkcyan;
            margin: 15px;
        }
        form {
            margin: 0 auto;
            width: 500px;
            background-color: aquamarine;
            border: solid blue;
        }
    </style>
</head>
<body>
<form action="/calculator" method="get">
    <h1>Simple Calculator</h1>
    <label> First Operand</label> <input type="text" name="first operand" style="padding-left: 20px"> <br>
    <label> Operator</label>
    <select name="Operator" >
        <option value="Addition">Addition</option>
        <option value="Subtraction">Subtraction</option>
        <option value="Multiplication">Multiplication</option>
        <option value="Division">Division</option>
    </select> <br>
    <label> Second Operand</label><input type="text" name="second operand"><br>
    <button type="submit"> calculator</button>
</form>
</body>
</html>