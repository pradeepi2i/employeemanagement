<jsp:include page="logout.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form"%>

<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Employee Management</title>
</head>
<body>
<p>CREATE EMPLOYEE</p>
<form:form>
      <table>
          <tr>
              <td>First Name:</td>
              <td><form:input type = "text" path="firstName" /></td>
          </tr>

              <td>Last Name:</td>
              <td><form:input type = "text" path="lastName" /></td>
          </tr>
          <tr>
              <td>Gender:</td>
              <td><form:input type = "text" path="gender" /></td>
          </tr>
          <tr>
              <td>Date of Birth:</td>
              <td><form:input type = "date" path="dateOfBirth" /></td>
          </tr>
          <tr>
              <td>Blood Group:</td>
              <td><form:input type = "text" path="bloodGroup" /></td>
          </tr>
          <tr>
              <td>Date of Joining:</td>
              <td><form:input type = "date" path="dateOfJoining" /></td>
          </tr>
          <tr>
              <td>Account Number:</td>
              <td><form:input type = "number" path="accountNumber" /></td>
          </tr>
          <tr>
              <td>IFSC Code:</td>
              <td><form:input type = "text" path="ifscCode" /></td>
          </tr>
          <tr>
              <td>Designation:</td>
              <td><form:input type = "text" path="designation" /></td>
          </tr>
          <tr>
              <td>Previous Experience:</td>
              <td><form:input type = "number" path="previousExperience" /></td>
          </tr>
          <tr>
              <td>Monthly Income:</td>
              <td><form:input type = "number" path="monthlyIncome" /></td>
          </tr>
          <p>Contact Details</p>
          <tr>
              <td>Type:</td>
              <td><form:input type = "text" path="type" /></td>
          </tr>
          <tr>
              <td>Country Code:</td>
              <td><form:input type = "text" path="countryCode" /></td>
          </tr>
          <tr>
              <td>Phone Number:</td>
              <td><form:input type = "number" path="phoneNumber" /></td>
          </tr>
          <p>Address Details</p>
          <tr>
              <td>Type:</td>
              <td><form:input type = "text" path="type" /></td>
          </tr>
          <tr>
              <td>Door Number:</td>
              <td><form:input type = "text" path="doorNumber" /></td>
          </tr>
          <tr>
              <td>Street :</td>
              <td><form:input type = "text" path="streetName" /></td>
          </tr>
          <tr>
              <td>City :</td>
              <td><form:input type = "text" path="cityName" /></td>
          </tr>
          <tr>
              <td>District :</td>
              <td><form:input type = "text" path="districtName" /></td>
          </tr>
          <tr>
              <td>State :</td>
              <td><form:input type = "text" path="stateName" /></td>
          </tr>
          <tr>
              <td>Country :</td>
              <td><form:input type = "text" path="countryName" /></td>
          </tr>
          <tr>
              <td>Postal Code:</td>
              <td><form:input type = "number" path="postalCode" /></td>
          </tr>
          <p>Work Place Details</p>
          <tr>
              <td>Floor Number:</td>
              <td><form:input path="floorNumber" /></td>
          </tr>
      </table>
</form:form>

<form:form id="addEmployee" modelAttribute="employee" action = "employee/add" method = "post" >
  First name : <input type = "text" name = "firstName"><br>
  Last name : <input type = "text" name = "lastName"><br>
  Gender : <input type = "text" name = "gender"><br>
  Date of Birth : <input type = "date" name = "dateOfBirth"><br>
  Date of Joining : <input type = "date" name = "dateOfJoining"><br>
  Blood Group : <input type = "text" name = "bloodGroup"><br>
  Account Number : <input type = "number" name = "accountNumber"><br>
  IFSC code : <input type = "text" name = "ifscCode"><br>
  Designation : <input type = "text" name = "designation"><br>
  Previous Experience : <input type = "number" name = "previousExperience"><br>
  Monthly Income : <input type = "text" name = "monthlyIncome"><br>
  <p>Contact Details</p>
  Type : <input type = "text" name = "type"><br>
  Country code : <input type = "text" name = "countryCode"><br>
  Phone number : <input type = "number" name = "phoneNumber"><br>
  <p>Address Details</p>
  Type : <input type = "text" name = "type"><br>
  Door number : <input type = "text" name = "doorNumber"><br>
  Street : <input type = "text" name = "streetName"><br>
  City : <input type = "text" name = "cityName"><br>
  District : <input type = "text" name = "districtName"><br>
  State : <input type = "text" name = "stateName"><br>
  Country : <input type = "text" name = "countryName"><br>
  Postal code : <input type = "number" name = "postalCode"><br>
  <p>Work Place Details</p>
  Floor number : <input type = "number" name = "floorNumber"><br>
  <input type="submit" value="Create" name="operation">
</form>
</body>
</html>
