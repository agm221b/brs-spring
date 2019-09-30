<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Booking</title>


</head>
<body>

Cancel a Booking:
	<form action="cancelbooking" method="POST">
		<table>

			<tr>
				<td>Booking ID</td>
				<td><input name="bookingId" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Cancel"></td>
			</tr>

		</table>
		</form>
		<br><br>
		<jsp:include page="ViewBookings.jsp"/>
		<jsp:include page="../linklib.jsp" />

</body>
</html>