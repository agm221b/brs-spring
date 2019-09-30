<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bookings</title>

</head>
<body>

<h1>Here are the list of bookings :-</h1>
	<table border="1" class="table table-striped">
		<tr>
			<th>Booking Id</th>
			<th>Date of Booking</th>
			<th>Mode of Payment</th>
			<th>Total Cost</th>
			<th>Booking Status</th>
			<th>Cancel</th>
		</tr>

		<a:forEach var="booking" items="${bookingList}">
			<tr>
				<td>${booking.bookingId}</td>
				<td>${booking.dateOfJourney}</td>
				<td>${booking.modeOfPayment}</td>
				<td>${booking.totalCost}</td>
				<td>${booking.bookingStatus}</td>
				<td><a  type="submit" class="waves-effect waves-light btn-small" href="cancelbooking">Cancel</a></td>
			</tr>
		</a:forEach>

	</table>
<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>