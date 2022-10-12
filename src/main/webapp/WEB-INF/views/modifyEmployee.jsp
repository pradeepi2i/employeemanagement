<jsp:include page="logout.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html"%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Employee Management</title>
</head>
<body>

<div>
    <p>UPDATE PROFILE</p>

<form modelAttribute = "employeeDTO"  action = "updateEmployee" method = "post">

    <input type = "hidden" value= "${employeeDTO.id}" name = "id" ><br>
    First name : <input type = "text" value= "${employeeDTO.firstName}" name = "firstName"><br>
    Last name : <input type = "text" value = "${employeeDTO.lastName}" name = "lastName"><br>
    Gender : <input type = "text" value = "${employeeDTO.gender}"  name = "gender"><br>
    Date of Birth : <input type = "text" value = "${employeeDTO.dateOfBirth}" name = "dateOfBirth"><br>
    Date of Joining : <input type = "text" value = "${employeeDTO.dateOfJoining}" name = "dateOfJoining"><br>
    Blood Group : <input type = "text" value = "${employeeDTO.bloodGroup}" name = "bloodGroup"><br>
    Account Number : <input type = "number" value = "${employeeDTO.accountNumber}" name = "accountNumber"><br>
    IFSC code : <input type = "text" value = "${employeeDTO.ifscCode}" name = "ifscCode"><br>
    Designation : <input type = "text" value = "${employeeDTO.designation}" name = "designation"><br>
    Previous Experience : <input type = "number" value = "${employeeDTO.previousExperience}" name = "previousExperience"><br>
    Salary : <input type = "text" value = "${employeeDTO.salary}" name = "salary"><br>

    <c:forEach items="${employeeDTO.mobileNumbers}" var="mobileNumber" varStatus="status">
                    <tr>
                        <td>Type:</td>
                        <td><input type = "text" name="mobileNumbers.type" value="${mobileNumber.type}"/></td>
                    </tr>
                    <tr>
                        <td>Country Code:</td>
                        <td><input type = "text" name="mobileNumbers.countryCode" value="${mobileNumber.countryCode}"/></td>
                    </tr>
                        <tr>
                            <td>Phone Number:</td>
                            <td><input type = "number" name="mobileNumbers.phoneNumber" value="${mobileNumber.mobileNumber}" /></td>
                    </tr>
    </c:forEach>


    <input type="submit" value="UpdateEmployee">
</form>
</div>
</body>
</html>
