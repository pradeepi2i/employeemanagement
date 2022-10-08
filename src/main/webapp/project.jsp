
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Project Management</title>
</head>
<body>

<button><a href="createProject.jsp" style="text-decoration:none">Add Project</a></button>

<p>SEARCH PROJECT</p>
<form action = "management/project/searchProject" method = "get">
    <table>
        <tr>
            <td>Project Id:</td>
            <td>
                <input type="number" name="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Search" />
            </td>
        </tr>
    </table>
</form>


 <p> UPDATE PROJECT</p>
    <form action = "management/project/modifyProject"  method = "get">
        <table>
                <tr>
                    <td>Project Id:</td>
                    <td>
                        <input type="number" name="id"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update" />
                    </td>
                </tr>
            </table>
    </form><br>

<p> ASSIGN EMPLOYEE PROJECT</p>
    <form action = "management/project/assign"  method = "get">
        Project Id: <input type = "number" name = "id"><br>
        Employee Id: <input type = "number" name = "employeeId"><br>
            <input type="submit" value="Assign" name = "operation">
    </form><br>

<p>DELETE PROJECT</p>
<form action = "management/project/deleteProject"  method = "get">
  Project Id: <input type = "number" name = "id"><br>
  <input type="submit" value="Delete" name = "operation">
</form>

</body>
</html>