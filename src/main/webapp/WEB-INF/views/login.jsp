<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action = "login" method = "gett">
  User Id : <input type = "number" name = "userId"><br>
  Password : <input type = "text" name = "password"><br>
  <input type="submit" value="Login">
</form>
</body>
</html>