<jsp:include page="logout.jsp" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Employee Management</title>
</head>
<body>

<!--form action = "login/index">
<input type = "submit" value = "Employee Management" name = "operation">
<input type = "submit" value = "Project Management" name = "operation">
</form-->

<button onclick="window.location.href = 'employee.jsp';">
    Employee Management
</button>

<button onclick="window.location.href = 'project.jsp';">
    Project Management
</button>
</body>
</html>
