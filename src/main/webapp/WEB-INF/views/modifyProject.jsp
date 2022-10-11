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
        <input type = "hidden" value= "${projectDTO.id}" name = "id"><br>
        Project name : <input type = "text"  value= "${projectDTO.name}" name = "name"><br>
        Domain : <input type = "text"  value= "${projectDTO.domain}" name = "domain"><br>
        Cost : <input type = "number" value= "${projectDTO.cost}" name = "cost"><br>
        Description : <input type = "text" value= "${projectDTO.description}" name = "description"><br>
        <input type="submit" value="UpdateProject">
    </form>
</div>
</body>
</html>
