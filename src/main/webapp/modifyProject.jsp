<jsp:include page="logout.jsp" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Project Management</title>
</head>
<body>

<div>

    <p>UPDATE PROJECT</p>
    <form modelAttribute = "projectDTO" action = "project/updateProject" method = "post">

        Project name : <input type = "text" value = "${name}" name = "name"><br>
        Domain : <input type = "text"  value = "${domain}" name = "domain"><br>
        Cost : <input type = "number" value = "${cost}" name = "cost"><br>
        Description : <input type = "text" value = "${description}" name = "description"><br>
        <input type="submit" value="UpdateProject">
    </form>
</div>
</body>
</html>
