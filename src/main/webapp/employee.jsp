
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>

<!--form action = "employee/create" >
    <input type="submit" value="Add Employee" name = "operation">
</form--><br>
<button><a href="create.jsp" style="text-decoration:none">Add Employee</a></button>

<p>SEARCH EMPLOYEE</p>
<form action = "employee/search" method="get" >
    Employee Id: <input type = "number" name = "id"><br>
    <input type="submit" value="Fetch" name = "operation">
</form><br>

 <p> UPDATE EMPLOYEE</p>
    <form action = "employee/update" method="get">
        Employee Id: <input type = "number" name = "id"><br>
            <input type="submit" value="Update" name = "operation">
    </form><br>


<p>DELETE EMPLOYEE</p>
<form action = "employee/delete" method="get">
    Employee Id: <input type = "number" name = "id"><br>
    <input type="submit" value="Delete" name = "operation">
</form><br>
</body>
</html>