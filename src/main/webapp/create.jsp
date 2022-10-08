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
<p>CREATE EMPLOYEE</p>
<form id="addEmployee" modelAttribute="employeeDTO" action = "employee/add" method = "post">
      <table>
          <tr>
              <td>First Name:</td>
              <td><input type = "text" name="firstName" /></td>
          </tr>

              <td>Last Name:</td>
              <td><input type = "text" name="lastName" /></td>
          </tr>
          <tr>
              <td>Gender:</td>
              <td><input type = "text" name="gender" /></td>
          </tr>
          <tr>
              <td>Date of Birth:</td>
              <td><input type = "date" name="dateOfBirth" /></td>
          </tr>
          <tr>
              <td>Blood Group:</td>
              <td><input type = "text" name="bloodGroup" /></td>
          </tr>
          <tr>
              <td>Date of Joining:</td>
              <td><input type = "date" name="dateOfJoining" /></td>
          </tr>
          <tr>
              <td>Account Number:</td>
              <td><input type = "number" name="accountNumber" /></td>
          </tr>
          <tr>
              <td>IFSC Code:</td>
              <td><input type = "text" name="ifscCode" /></td>
          </tr>
          <tr>
              <td>Designation:</td>
              <td><input type = "text" name="designation" /></td>
          </tr>
          <tr>
              <td>Previous Experience:</td>
              <td><name:input type = "number" name="previousExperience" /></td>
          </tr>
          <tr>
              <td>Monthly Income:</td>
              <td><input type = "number" name="monthlyIncome" /></td>
          </tr>
          <tr>
              <p>Contact Details</p>
          </tr>
          <tr>
              <td>Type:</td>
              <td><input type = "text" name="type" /></td>
          </tr>
          <tr>
              <td>Country Code:</td>
              <td><input type = "text" name="countryCode" /></td>
          </tr>
          <tr>
              <td>Phone Number:</td>
              <td><input type = "number" name="phoneNumber" /></td>
          </tr>
          <tr>
              <p>Address Details</p>
          </tr>
          <tr>
              <td>Type:</td>
              <td><input type = "text" name="type" /></td>
          </tr>
          <tr>
              <td>Door Number:</td>
              <td><input type = "text" name="doorNumber" /></td>
          </tr>
          <tr>
              <td>Street :</td>
              <td><input type = "text" name="streetName" /></td>
          </tr>
          <tr>
              <td>City :</td>
              <td><input type = "text" name="cityName" /></td>
          </tr>
          <tr>
              <td>District :</td>
              <td><input type = "text" name="districtName" /></td>
          </tr>
          <tr>
              <td>State :</td>
              <td><input type = "text" name="stateName" /></td>
          </tr>
          <tr>
              <td>Country :</td>
              <td><input type = "text" name="countryName" /></td>
          </tr>
          <tr>
              <td>Postal Code:</td>
              <td><input type = "number" name="postalCode" /></td>
          </tr>
          <tr>
              <p>Work Place Details</p>
          </tr>
          <tr>
              <td>Floor Number:</td>
              <td><input name="floorNumber" /></td>
          </tr>
          <tr>
              <td><input type="submit" value="Create" name="operation"></td>
          </tr>
      </table>
</form>

<!--form:form id="addEmployee" modelAttribute="employee" action = "employee/add" method = "post" >
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
</form-->
</body>
</html>
