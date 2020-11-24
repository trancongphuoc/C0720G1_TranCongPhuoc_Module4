<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create box electronic</title>
</head>
<body>
<h1>Create box electronic</h1>
<form:form action="/create" method="post" modelAttribute="boxElectronic">
    <label>Languages: </label>
    <select name="language">
        <option>English</option>
        <option>Vietnamese</option>
        <option>Japanese</option>
        <option>Chinese</option>
    </select>
    <br>
    <label>Page Size: </label>
    <label>
        Show
        <select name="pageSize">
            <option>5</option>
            <option>10</option>
            <option>15</option>
            <option>25</option>
            <option>50</option>
            <option>100</option>
        </select>
        email per pages
    </label>
    <br>
    <label>Spam filter</label>
    <input type="checkbox" name="filter" value="true">
    <br>
    <label>Signature</label>
    <textarea rows="3" name="signature"></textarea>
    <br>
    <input type="submit" value="Update">
</form:form>
</body>
</html>
