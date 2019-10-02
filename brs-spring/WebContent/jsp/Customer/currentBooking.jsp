<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="viewbooking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Booking Details</title>
</head>
<body>
<h4>Current Booking Details</h4>
<br>
<table border=1 class="table-hover">
<tr>
<th style="display: none">Booking Id</th>
<th>Source</th>
<th>Destination</th>
<th>Date Of Journey</th>
<th>Mode Of Payment</th>
<th>Total Cost</th>
</tr>
<viewbooking:forEach var="booking" items="${bookings}">
<tr>
<td style="display: none">${booking.getBookingId()}</td>
<td>${booking.getBus().getSource() }</td>
<td>${booking.getBus().getDestination() }</td>
<td>${booking.getDateOfJourney() }</td>
<td>${booking.getModeOfPayment() }</td>
<td>${booking.getTotalCost() }</td>
</tr>
</viewbooking:forEach>
</table>

<h3>Bus details</h3>

<table border=1>
<tr>
<th>Bus Name</th>
<th>Bus Type</th>
<th>Bus Class</th>
<th>Start Time</th>
<th>End Time</th>
</tr>
<viewbooking:forEach var="booking" items="${bookings }">
<td>${booking.getBus().getBusName() }</td>
<td>${booking.getBus().getBusType() }</td>
<td>${booking.getBus().getBusClass() }</td>
<td>${booking.getBus().getStartTime() }</td>
<td>${booking.getBus().getEndTime() }</td>
</viewbooking:forEach>
</table>
<h3>Passenger Details</h3>
<table border=1>
<tr>
<th>Passenger Id</th>
<th>Passenger Name</th>
<th>Passenger Age</th>
<th>Passenger Gender</th>
</tr>
<viewbooking:forEach var="passenger" items="${passengers}"></viewbooking:forEach>
<tr>
<td>${passenger.getPassengerId() }</td>
<td>${passenger.getPassengerName() }</td>
<td>${passenger.getPassengerAge() }</td>
<td>${passenger.getPassengerGender() }</td>
</tr>
</table>

<a href="customerhome"><input type="button" value="Go To Home"></a>&emsp;&emsp;
<a href="viewallbookings"><input type="button" value="View All Tickets"></a>&emsp;&emsp;
<a href="cancelbooking"><input type="button" value="Cancel Ticket"></a>
<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>