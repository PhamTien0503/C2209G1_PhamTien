<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="get">
    <h1>Simple Calculator</h1> 
    <label> First Operand</label> <input type="text" name="first operand">
    <label> Operator</label>
    <select name="Operator" >
        <option value="Addition">Addition</option>
        <option value="Subtraction">Subtraction</option>
        <option value="Multiplication">Multiplication</option>
        <option value="Division">Division</option>
    </select>
    <label> Second Operand</label><input type="text" name="second operand">
    <button type="submit"> calculator</button>
</form>
</body>
</html>