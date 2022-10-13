<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action = "login" method = "post">
  User Name : <input type = "text" name = "userName"><br>
  Password : <input type = "text" name = "password"><br>
  <input type="submit" value="Login">
</form>
</body>
</html>