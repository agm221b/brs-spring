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
<h3>Here are the list of bookings :-</h3>
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

				<td>${booking.bookingId}</td>
				<td>${booking.dateOfJourney}</td>
				<td>${booking.getBus().getBusName() }</td>
				<td>${booking.modeOfPayment}</td>
				<td>${booking.totalCost}</td>
				<td>${booking.bookingStatus}</td>
				<td><a  href="cancelbooking?bookingId=${booking.bookingId }" class="waves-effect waves-light btn-small" >Cancel</a></td>

			</tr>
		</a:forEach>

	</table>
	
	<a href="customerhome"><input type="button" value="Go to home"></a>
<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>