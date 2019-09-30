<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

</head>
<body>

	<h2>
		<i>Welcome to BusNama </i><br>
	</h2>
	<a href="login"> <input type="button" value="Login" /></a>
	<a href="register"> <input type="button" value="Register" /></a>
	<a href="help"> <input type="button" value="Help" /></a>
	<a href="aboutUs"> <input type="button" value="About Us" /></a>

	<br>

	<a href="addbus">Add Bus</a>
	<a href="adminhome">Admin Home</a>
	<a href="customerhome">Customer Home</a>
	<a href="searchbuses">Search Buses</a>

	<jsp:include page="linklib.jsp"></jsp:include>

</body>
</html>