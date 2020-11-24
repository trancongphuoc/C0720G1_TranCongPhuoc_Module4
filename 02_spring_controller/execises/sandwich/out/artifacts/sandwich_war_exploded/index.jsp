<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/23/2020
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/save" method="get">
    <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="lettuce">
    <label>Tomato</label>
    <input type="checkbox" name="condiment" value="tomato">
    <label>Mustard</label>
    <input type="checkbox" name="condiment" value="mustard">
    <label>Sprouts</label>
    <input type="checkbox" name="condiment" value="sprouts">

    <input type="submit" value="Submit">
</form>
</body>
</html>
