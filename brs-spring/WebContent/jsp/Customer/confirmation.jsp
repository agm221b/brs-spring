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
<h1>Your booking has been confirmed. Click on the button below to view your current bookings</h1>
<br>
<a href="viewcurrentbooking"><input type="button" value="View Current Booking"></a>
	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>