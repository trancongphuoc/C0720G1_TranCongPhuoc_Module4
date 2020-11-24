<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/23/2020
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculate">
    <input type="text" name="firstNumber">
    <input type="text" name="secondNumber">
    <br>
    <input type="submit" value="+" name="calculation">
    <input type="submit" value="-" name="calculation">
    <input type="submit" value="x" name="calculation">
    <input type="submit" value="/" name="calculation">

    <h2>${result}</h2>
    <h2 style="color: red">${message}</h2>
</form>
</body>
</html>
