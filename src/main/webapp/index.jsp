<jsp:include page="logout.jsp" />

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" %>

<!DOC TYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Employee Management</title>
</head>
<body>

<!--form action = "employee">
<input type = "submit" value = "Employee Management" name = "operation">
</form-->

<button><a href="employee.jsp" style="text-decoration:none">Employee Management</a></button>

<button><a href="project.jsp" style="text-decoration:none">Project Management</a></button>

<!--button onclick="window.location.href = 'employee.jsp';">
    Employee Management
</button>
<button onclick="window.location.href = 'project.jsp';">
    Project Management
</button-->
</body>
</html>
