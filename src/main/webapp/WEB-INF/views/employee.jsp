
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>

<form action = "create" method="post">
    <input type="submit" value="Add Employee">
</form><br>

<p>SEARCH EMPLOYEE</p>
<form action = "search" method="get" >
    Employee Id: <input type = "number" name = "id"><br>
    <input type="submit" value="Fetch">
</form><br>

 <p> UPDATE EMPLOYEE</p>
    <form action = "update" method="get">
        Employee Id: <input type = "number" name = "id"><br>
            <input type="submit" value="Update" name = "operation">
    </form><br>


<p>DELETE EMPLOYEE</p>
<form action = "delete" method="get">
    Employee Id: <input type = "number" name = "id"><br>
    <input type="submit" value="Delete" name = "operation">
</form><br>
</body>
</html>