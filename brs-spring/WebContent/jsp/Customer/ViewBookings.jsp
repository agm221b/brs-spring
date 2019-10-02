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
			<th>Date of Journey</th>
			<th>Bus</th>
			<th>Mode of Payment</th>
			<th>Total Cost</th>
			<th>Booking Status</th>
			<th>Cancel</th>
		</tr>

		<a:forEach var="booking" items="${bookings}">
			<tr>
				<td>${booking.getBookingId()}</td>
				<td>${booking.getDateOfJourney()}</td>
				<td>${booking.getBus().getBusName() }</td>
				<td>${booking.getModeOfPayment()}</td>
				<td>${booking.getTotalCost()}</td>
				<td>${booking.getBookingStatus()}</td>
				<td><a  type="submit" class="waves-effect waves-light btn-small" href="cancelbooking">Cancel</a></td>
			</tr>
		</a:forEach>

	</table>
	
	<a href="customerhome"><input type="button" value="Go to home"></a>
<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>