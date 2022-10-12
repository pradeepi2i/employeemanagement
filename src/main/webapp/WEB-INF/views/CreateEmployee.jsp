<jsp:include page="logout.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
  <meta charset="utf-8"/>
  <title>Employee Management</title>
</head>
<body>
<p>CREATE EMPLOYEE</p>
<form modelAttribute="employeeDTO" action = "add" method = "post">
      <table>
          <tr>
              <td>First Name:</td>
              <td><input type = "text" name="firstName" /></td>
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><input type = "text" name="lastName" /></td>
          </tr>
          <tr>
              <td>Gender:</td>
              <td><input type = "text" name="gender" /></td>
          </tr>
          <tr>
              <td>Date of Birth:</td>
              <td><input type = "text" name="dateOfBirth" /></td>
          </tr>
          <tr>
              <td>Blood Group:</td>
              <td><input type = "text" name="bloodGroup" /></td>
          </tr>
          <tr>
              <td>Email:</td>
              <td><input type = "text" name="emailId" /></td>
          </tr>
          <tr>
              <td>Date of Joining:</td>
              <td><input type = "text" name="dateOfJoining" /></td>
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
              <td><input type = "number" name="previousExperience" /></td>
          </tr>
          <tr>
              <td>Salary:</td>
              <td><input type = "number" name="salary" /></td>
          </tr>



                <!--tr>
                    <td>Type:</td>
                    <td><input type = "text" name="mobile.type" /></td>
                </tr>
                <tr>
                    <td>Country Code:</td>
                    <td><input type = "text" name="mobile.countryCode" /></td>
                </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type = "number" name="mobile.mobileNumber" /></td>
                </tr-->

          <c:forEach items="${employeeDTO.mobileNumbers}" var="mobile" varStatus="status">

              <tr>
                  <td>Type</td>
                  <td><input name="mobileNumbers.[${status.index}].type" placeholder="${mobile.type}" /></td>
              </tr>

              <tr>
                  <td>Country Code</td>
                  <td><input name="mobileNumbers.[${status.index}].countryCode" placeholder="${mobile.countryCode}" /></td>
              </tr>
              <tr>
                  <td>Mobile Number</td>
                  <td><input name="mobileNumbers.[${status.index}].mobileNumber" placeholder="${mobile.mobileNumber}" /></td>
              </tr>
         </c:forEach>
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
              <td>Floor Number:</td>
              <td><input name="workPlace.floorNumber" /></td>
          </tr>
          <tr>
              <td><input type="submit" value="Create" ></td>
          </tr>
      </table>
</form>


</body>
</html>
