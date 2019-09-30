<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tab" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Users</title>
</head>
<body>
<h1>Here are the list of users:-</h1>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Username</th>
			<th>User Type</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Edit</th>
		</tr>

		<tab:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td>${user.userType}</td>
				<td>${user.email}</td>
				<td>${user.phoneNumber}</td>
				<td><a  type="submit" class="waves-effect waves-light btn-small" href="edituser">Edit</a></td>
			</tr>
		</tab:forEach>

	</table>
<jsp:include page="../linklib.jsp"></jsp:include>


</body>
</html>