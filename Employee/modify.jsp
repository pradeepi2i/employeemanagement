<jsp:include page="logout.jsp" />

<%@ page import="com.ideas2it.employeemanagement.controller.EmployeeController"%>
<%@ page import="com.ideas2it.employeemanagement.dto.EmployeeDTO"%>
<%@ page import="com.ideas2it.employeemanagement.model.Mobile"%>
<%@ page import="com.ideas2it.employeemanagement.model.Address"%>
<%@ page import="java.util.Set"%>
<%@ page contentType="text/html"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Employee Management</title>
</head>
<body>

<div>
    <p>UPDATE PROFILE</p>

<form: id = "updateEmployee" modelAttribute = "employee" action = "employee/updateEmployee" method = "post">
     <% EmployeeDTO employee = (EmployeeDTO)request.getAttribute("employeeDTO"); %>
    <% int id = employee.getId(); %>
    <input type = "hidden" value = "<%=employee.getId()%>" name = "id" ><br>
    First name : <input type = "text" value = "<%=employee.getFirstName()%>" name = "firstName"><br>
    Last name : <input type = "text" value = "<%=employee.getLastName()%>" name = "lastName"><br>
    Gender : <input type = "text" value = "<%=employee.getGender()%>" name = "gender"><br>
    Date of Birth : <input type = "date" value = "<%=employee.getDateOfBirth()%>" name = "dateOfBirth"><br>
    Date of Joining : <input type = "date" value = "<%=employee.getDateOfJoining()%>" name = "dateOfJoining"><br>
    Blood Group : <input type = "text" value = "<%=employee.getBloodGroup()%>"name = "bloodGroup"><br>
    Account Number : <input type = "number" value = "<%=employee.getAccountNumber()%>" name = "accountNumber"><br>
    IFSC code : <input type = "text" value = "<%=employee.getIfscCode()%>"name = "ifscCode"><br>
    Designation : <input type = "text" value = "<%=employee.getDesignation()%>" name = "designation"><br>
    Previous Experience : <input type = "number" value = "<%=employee.getPreviousExperience()%>" name = "previousExperience"><br>
    Monthly Income : <input type = "text" value = "<%=employee.getSalary()%>" name = "monthlyIncome"><br>

    <% for (Mobile mobile : employee.getMobileNumbers()) { %>
        <p>Contact Details</p>
        Type : <input type = "text" value = "<%=mobile.getType()%>" name = "type"><br>
        Country code : <input type = "text" value = "<%=mobile.getCountryCode()%>" name = "countryCode"><br>
        Phone number : <input type = "number" value = "<%=mobile.getMobileNumber()%>" name = "phoneNumber"><br>
    <%} %>

    <% for (Address address : employee.getAddresses()) { %>
        <p>Address Details</p>
        Type : <input type = "text" value = "<%=address.getType()%>" name = "type"><br>
        Door number : <input type = "text" value = "<%=address.getDoorNumber()%>" name = "doorNumber"><br>
        Street : <input type = "text" value = "<%=address.getStreetName()%>" name = "streetName"><br>
        City : <input type = "text" value = "<%=address.getCityName()%>" name = "cityName"><br>
        District : <input type = "text" value = "<%=address.getDistrictName()%>" name = "districtName"><br>
        State : <input type = "text" value = "<%=address.getStateName()%>"name = "stateName"><br>
        Country : <input type = "text" value = "<%=address.getCountryName()%>" name = "countryName"><br>
        Postal code : <input type = "number" value = "<%=address.getPostalCode()%>" name = "postalCode"><br>
    <%} %>
    <input type="submit" value="UpdateEmployee" name="operation">
</form>
</div>

</body>
</html>
