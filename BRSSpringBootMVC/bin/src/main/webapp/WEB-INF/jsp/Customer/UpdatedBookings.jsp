<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Here are the list of bookings :-</h3>
	<table border="1" class="table table-striped">
		<tr>
			<th>Booking Id</th>
			<th>Date of Journey</th>
			<th>Bus</th>
			<th>Mode of Payment</th>
			<th>Total Cost</th>
			<th>Booking Status</th>
		</tr>

		<a:forEach var="booking" items="${bookings}">
			<tr>

				<td>${booking.bookingId}</td>
				<td>${booking.dateOfJourney}</td>
				<td>${booking.modeOfPayment}</td>
				<td>${booking.totalCost}</td>
				<td>${booking.bookingStatus}</td>
			</tr>
		</a:forEach>

	</table>
	
	<a href="customerhome"><input type="button" value="Go to home"></a>
<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>