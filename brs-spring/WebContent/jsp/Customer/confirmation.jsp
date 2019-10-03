<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BusNama</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="customerhome">Home</a></li>
    </ul>
  </div>
</nav>
<h1>Your booking has been confirmed. Click on the button below to view your current bookings</h1>
<br>
<a href="viewcurrentbooking"><input type="button" value="View Current Booking"></a>
	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>