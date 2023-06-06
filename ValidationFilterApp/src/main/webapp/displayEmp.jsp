<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output</title>
</head>
<body bgcolor='lightgreen'>
	<center>
		<c:choose>
			<c:when test="${status eq 'success' }">
				<h1 style='color: green;'>EMPLOYEE REGISTRATION SUCCESSFUL</h1>
				<h2 style='color: green;'>EMPLOYEE REGISTRATION DETAILS</h2>
				<table border='1'>
					<tr>
						<th>EID</th>
						<td>${employee.eid}</td>
					</tr>
					<tr>
						<th>ENAME</th>
						<td>${employee.ename}</td>
					</tr>
					<tr>
						<th>EAGE</th>
						<td>${employee.eage}</td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<td>${employee.email}</td>
					</tr>
					<tr>
						<th>MOBILE</th>
						<td>${employee.mobile}</td>
					</tr>
					<tr>
						<th>STATUS</th>
						<td>${employee.status}</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<h1 style='color: red;'>EMPLOYEE REGISTRATION FAILED</h1>
			</c:otherwise>
		</c:choose>
	</center>

</body>
</html>