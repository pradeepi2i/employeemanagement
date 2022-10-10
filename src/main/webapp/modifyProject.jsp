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
    <form modelAttribute = "projectDTO" action = "updateProject" method = "post">

        Project Id : <input type = "number" name = "id"><br>
        Project name : <input type = "text" name = "name"><br>
        Domain : <input type = "text"  name = "domain"><br>
        Cost : <input type = "number" name = "cost"><br>
        Description : <input type = "text" name = "description"><br>
        <input type="submit" value="UpdateProject">
    </form>
</div>
</body>
</html>
