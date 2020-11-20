<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/20/2020
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<c:if test="${dictionary != null}"><h1>${dictionary.keyWord} : ${dictionary.means}</h1></c:if>
<c:if test="${message != null}"><h1 style="color: red">${message}</h1></c:if>


</body>
</html>
