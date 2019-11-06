<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link rel="stylesheet" href="css/customer.css">
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="customerhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="customerhome">Home</a></li>
				<li><a href="help">FAQs</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="viewallbookings">View All Bookings</a></li>
						<li><a href="#">Manage Profile</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
<h1>Your booking has been confirmed. Click on the button below to view your current bookings</h1>
<br>
<a href="viewcurrentbooking"><input type="button" value="View Current Booking"></a>
	<jsp:include page="../linklib.jsp"></jsp:include>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>