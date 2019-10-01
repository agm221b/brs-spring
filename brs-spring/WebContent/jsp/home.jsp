<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

</head>
<body>

	<h3 onmouseover="" align="center">
		<i>Welcome to BusNama </i><br>
	</h3>
	<div class="container">
		<div class="row" align="left">
		<a href="login"> <input type="button" class="waves-effect waves-light btn" value="Login"></a><br>
		</div>
		<div class="row" align="left">
		 <a href="register"> <input type="button" class="waves-effect waves-light btn" value="Register"></a><br>
		  </div>
		  <div class="row" align="left">
		 <a href="help"> <input type="button" class="waves-effect waves-light btn" value="Help"></a><br>
		  </div>
		  <div class="row" align="left">
		 <a href="aboutUs"> <input type="button" class="waves-effect waves-light btn" value="About Us"></a><br>
		 </div>
	
	<br>

	<a href="addbus">Add Bus</a>
	<a href="adminhome">Admin Home</a>
	<a href="customerhome">Customer Home</a>
	<a href="searchbuses">Search Buses</a>
	</div>
	<jsp:include page="linklib.jsp"></jsp:include>

</body>
</html>