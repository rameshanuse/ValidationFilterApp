<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output</title>
</head>
<body>
	<center>
	<h1 style='color:red;'>EMPLOYEE REGISTRATION DETAILS</h1>
	<form method='post' action='./reg'>
		<table border='1'>
			<tr>
				<th>EID</th>
				<td><input type='text' name='eid' value='${employee.eid}' /></td>
				<td><font color='red' size='5'>"${eid_err_msg}"</font></td>
			</tr>
			<tr>
				<th>ENAME</th>
				<td><input type='text' name='ename' value='${employee.ename}' /></td>
				<td><font color='red' size='5'>"${ename_err_msg}"</font></td>
			</tr>
			<tr>
				<th>EAGE</th>
				<td><input type='text' name='eage' value='${employee.eage}' /></td>
				<td><font color='red' size='5'>"${eage_err_msg}"</font></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td>${employee.email}</td>
				<td><input type='text' name='email' value='${employee.email}' /></td>
				<td><font color='red' size='5'>"${email_err_msg}"</font></td>
			</tr>
			<tr>
				<th>MOBILE</th>
				<td><input type='text' name='mobile' value='${employee.mobile}' /></td>
				<td><font color='red' size='5'>"${mobile_err_msg}"</font></td>
			</tr>
			<tr>
				<th></th>
				<td><input type='submit' value='reg' /></td>
			</tr>
		</table>
		</form>
	</center>

</body>
</html>