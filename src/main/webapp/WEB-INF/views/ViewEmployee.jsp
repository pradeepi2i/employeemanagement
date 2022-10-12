<jsp:include page="logout.jsp" />

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>
${message} : ${id}
${employeeDTO}<br>
${address}<br>
${mobiles}<br>
${projects}<br>
${work}

</body>
</html>