<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

<style type="text/css">

.page-header{
position:relative;
top: 0px;
	align-content:center;
	background-color: #ffe0b2;
	
}
</style>
</head>
<body>

<div class="page-header" align="center">
		<h3 style="font: bolder; font-family:cursive;">BusNama : Bas Explore Karo</h3>
	</div>
<jsp:include page="linklib.jsp"></jsp:include>
	

	<h3  align="center">
		<i>Welcome</i><br>
	</h3>
	<div class="container">
		<div class="row" align="left">
			<a href="login"> <input type="button"
				class="waves-effect waves-light btn" value="Login"></a><br>
		</div>
		<div class="row" align="left">
			<a href="register"> <input type="button"
				class="waves-effect waves-light btn" value="Register"></a><br>
		</div>
		<div class="row" align="left">
			<a href="help"> <input type="button"
				class="waves-effect waves-light btn" value="Help"></a><br>
		</div>
		<div class="row" align="left">
			<a href="aboutUs"> <input type="button"
				class="waves-effect waves-light btn" value="About Us"></a><br>
		</div>

		<br> <a href="addbus">Add Bus</a> <a href="adminhome">Admin
			Home</a> <a href="customerhome">Customer Home</a> <a href="searchbuses">Search
			Buses</a>
	</div>
	<jsp:include page="../webjar/jsp/footer.jsp"></jsp:include>

</body>
</html>