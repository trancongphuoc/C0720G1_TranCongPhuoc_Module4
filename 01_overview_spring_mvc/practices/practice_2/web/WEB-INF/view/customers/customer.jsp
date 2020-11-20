<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/20/2020
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<div class="card" style="width: 18rem; margin-left: 35%; margin-top: 5%">
    <h2 class="card-header">${customer.id}</h2>
    <div class="card-body">
       <p>${customer.name}</p>
       <p>${customer.email}</p>
       <p>${customer.address}</p>
    </div>
</div>
</body>
</html>
