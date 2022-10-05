<jsp:include page="logout.jsp" />

<%@ page import="com.ideas2it.employeemanagement.dto.ProjectDTO"%>
<%@ page contentType="text/html"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Project Management</title>
</head>
<body>

<div>

    <p>UPDATE PROJECT</p>
    <form action = "project/updateProject" method = "post">

        <% ProjectDTO project = request.getAttribute("projectDTO"); %>
        Project name : <input type = "text" value = "<%=project.getName()%>" name = "projectName"><br>
        Domain : <input type = "text" value = "<%=project.getDomain()%>" name = "domain"><br>
        Cost : <input type = "number" value = "<%=project.getCost()%>" name = "cost"><br>
        Description : <input type = "text" value = "<%=project.getDescription()%>" name = "description"><br>
        <input type="submit" value="UpdateProject" name="operation">
    </form>
</div>
</body>
</html>
