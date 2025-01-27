<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

<h2>Adding an Employee into the database</h2>

<springform:form modelAttribute="emp" action="saveEmployee" method="post">


Employee Name <springform:input path="empName"/> <br/>
<springform:errors path="empName"/>

Employee Salary <springform:input path="empSal"/> <br/>

Employee Category <springform:select path="roleId" items="${EmpMap}"></springform:select> <br/>

<input type="submit" value="Save Details"/>

</springform:form>


</body>
</html>