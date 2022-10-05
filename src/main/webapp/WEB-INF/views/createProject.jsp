<jsp:include page="logout.jsp" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Employee Management</title>
</head>
<body>

<p>CREATE PROJECT</p>
<form: id = "addProject" modelAttribute = "project" action = "project/addProject" method = "post">
  Project name : <input type = "text" name = "projectName"><br>
  Domain : <input type = "text" name = "domain"><br>
  Cost : <input type = "number" name = "cost"><br>
  Description : <input type = "text" name = "description"><br>
  <input type="submit" value="Create" name="operation">
</form>

</body>
</html>
