<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Employees</title>
</head>
<body>

<table border=1>
<thead>
	<tr>
		<td>Employee ID</td>
		<td>Employee Name</td>
		<td>Employee Salary</td>
		<td>Employee Role ID</td>
		<td>Remove</td>
	</tr>
</thead>

<tbody>

<core:forEach items="${eList}" var="e">
	<tr>
		<td>${e.empId}</td>
		<td>${e.empName}</td>
		<td>${e.empSal}</td>
		<td>${e.roleId}</td>
		<td><a href="remove?eId=${e.empId}">Delete</a></td>
	</tr>
</core:forEach>
</tbody>




</table>

</body>
</html>