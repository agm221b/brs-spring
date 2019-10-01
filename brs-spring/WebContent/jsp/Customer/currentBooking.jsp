<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="viewbooking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Current Booking Details</h1>
<br>
<table border=1>
<tr>
<th>Booking Id</th>
<th>Source</th>
<th>Destination</th>
<th>Date Of Journey</th>
<th>Mode Of Payment</th>
<th>Total Cost</th>
</tr>
<viewbooking:forEach var="booking" items="${bookings}">
<tr>
<td>${booking.getBookingId()}</td>
<td>${booking.getBus().getSource() }</td>
<td>${booking.getBus().getDestination() }</td>
<td>${booking.getDateOfJourney() }</td>
<td>${booking.getModeOfPayment() }</td>
<td>${booking.getTotalCost() }</td>
</tr>
</viewbooking:forEach>
</table>
</body>
</html>