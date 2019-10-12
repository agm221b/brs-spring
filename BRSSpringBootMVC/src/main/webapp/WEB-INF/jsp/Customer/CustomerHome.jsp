<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="search"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Customer Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/customer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


</head>
<body style="background: url(img/bus4.jpg);
	background-size: cover;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="customerhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="customerhome">Home</a></li>
				<li><a href="help">FAQs</a></li>
				<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="viewallbookings">View All Bookings</a></li>
          <li><a href="#">Manage Profile</a></li>
        </ul>
      </li>
      <li><form action="<%=request.getContextPath()%>/logout" method="POST">
		<input type="submit" value="Logout" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form></li>
			</ul>
		</div>
	</nav>
	<h2>
		<i>Welcome to BusNama </i><br>
	</h2>
	<a class="waves-effect waves-light btn" href="addbooking">Create
		Booking</a>
	<br>
	<br>
	<a class="waves-effect waves-light btn" href="viewallbookings">View
		Bookings</a>
	<br>
	<br>
	<a class="waves-effect waves-light btn" href="cancelbooking">Cancel
		Booking</a>
	<br>
	<br>
	<form action="<%=request.getContextPath()%>/logout" method="POST">
		<input type="submit" value="Logout" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<jsp:include page="../linklib.jsp" />

</body>
</html>