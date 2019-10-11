<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="show"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
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
	<div class="container">
		<show:forEach var="booking" items="${bookings }">
			<div class="row" style="width: auto;">
				<div class="card medium">
					<div class="card-image waves-effect waves-block waves-light">
						<!-- <img class="activator" src="images/office.jpg"> -->
					</div>
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Booking
							Id: ${booking.bookingId }<i
							class="glyphicon glyphicon-option-vertical right"></i>
						</span>
						<p>
							Date Of Journey: ${booking.dateOfJourney }<br> Booking
							Status: ${booking.bookingStatus }<br> Mode Of Payment:
							${booking.modeOfPayment }<br> Total Cost:
							${booking.totalCost }<br>

						</p>
					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">Passenger
							Details<i class="glyphicon glyphicon-remove right"></i>
						</span>
						<p>
						<table>
							<tr>
								<th>Passenger Id</th>
								<th>Passenger Name</th>
								<th>Passenger Age</th>
								<th>Passenger Gender</th>
							</tr>
						</table>
						<show:forEach var="passenger" items="${booking.passengers }">
					      Passenger Id: ${passenger.getPassengerId() }
					      <br>
					      Passenger Name: ${passenger.getPassengerName() }
					      <br>
					      Passenger Age: ${passenger.getPassengerAge() }
					      <br>
					      Passenger Gender: ${passenger.getPassengerGender() }
      						<br>
							<br>
						</show:forEach>
						
					</div>
				</div>
			</div>
		</show:forEach>
	</div>
	<a href="customerhome"><input type="button" value="Go to home"></a>
	<a href="report"><input type="button"
		value="Download booking report"></a>

	<jsp:include page="../linklib.jsp"></jsp:include>

</body>
</html>