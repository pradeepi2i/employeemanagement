
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Project Management</title>
</head>
<body>

<form action = "project/create" method = "post">
    <input type="submit" value="Add Project" >
</form><br>

<p>SEARCH PROJECT</p>
<form action = "project/searchProject" method = "get">
    Project Id: <input type = "number" name = "id"><br>
    <input type="submit" value="Fetch" name = "operation">
</form>


 <p> UPDATE PROJECT</p>
    <form action = "project/modifyProject"  method = "get">
        Project Id: <input type = "number" name = "id"><br>
            <input type="submit" value="Update" name = "operation">
    </form><br>

<p> ASSIGN EMPLOYEE PROJECT</p>
    <form action = "project/assign"  method = "get">
        Project Id: <input type = "number" name = "id"><br>
        Employee Id: <input type = "number" name = "employeeId"><br>
            <input type="submit" value="Assign" name = "operation">
    </form><br>

<p>DELETE PROJECT</p>
<form action = "project/deleteProject"  method = "get">
  Project Id: <input type = "number" name = "id"><br>
  <input type="submit" value="Delete" name = "operation">
</form>

</body>
</html>