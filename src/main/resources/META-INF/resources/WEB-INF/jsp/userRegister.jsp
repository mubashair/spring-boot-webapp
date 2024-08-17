<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-3.7.1.min.js">
<!--this is how we can add js library -->
	
</script>
<script src="js/user.js">
	
</script>
</head>
<body>
	<div style="text-align: center;">
		<h1>User Registration</h1>
	</div>
	<c:if test="${ not empty successMessage }">
		<div id="successMessage" style="color: green; text-align: center;">
			<c:out value="${successMessage}" />
		</div>
	</c:if>
	
		<div id="errorMessage" style="color: red; text-align: center;">
			<c:out value="${errorMessage}" />
		</div>
	
	<form name="userForm" action="saveUser" method="POST">
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"
					placeholder="Please enter first name" required=true
					style="height: 30px;"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"
					placeholder="Please enter last name" required=true
					style="height: 30px;"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" id="email" name="email"
					placeholder="Please enter email" required=true
					style="height: 30px;"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					placeholder="Please enter password" required=true
					style="height: 30px;"></td>
			</tr>

		</table>
		<div style="text-align: center">
			<button type="submit" name="submitbtn" style="height: 30px;">Please
				Submit</button>
		</div>
	</form>
</body>
</html>