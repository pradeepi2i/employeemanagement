<jsp:include page="logout.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
  <meta charset="utf-8"/>
  <title>Employee Management</title>
</head>
<body>

<p>CREATE PROJECT</p>
<form modelAttribute = "projectDTO" action = "management/project/addProject" method = "post">
    <table>
        <tr>
            <td>Project Name:</td>
            <td>
                <input name="name"/>
            </td>
        </tr>
        <tr>
            <td>Domain:</td>
            <td>
                <input name="domain" />
            </td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td>
                <input  type="number" name="cost" />
            </td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>
                <input name="description" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>
