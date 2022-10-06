<jsp:include page="logout.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Employee Management</title>
</head>
<body>

<p>CREATE PROJECT</p>

<form:form id = "addProject" modelAttribute = "project" action = "project/addProject">
      <table>
          <tr>
              <td><form:label path = "name">Project name</form:label></td>
              <td><form:input type="text" path = "name" /></td>
          </tr>
          <tr>
              <td><form:label path = "domain">Domain</form:label></td>
              <td><form:input type="text" path = "domain" /></td>
          </tr>
          <tr>
              <td><form:label path = "cost">Cost</form:label></td>
              <td><form:input type="number" path = "cost" /></td>
          </tr>
          <tr>
              <td><form:label path = "description">Description</form:label></td>
              <td><form:input type="text" path = "description" /></td>
          </tr>
      </table>

      <input type="submit" value="Create" >
</form:form>

</body>
</html>
