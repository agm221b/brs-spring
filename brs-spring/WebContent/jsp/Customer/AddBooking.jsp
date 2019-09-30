<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>


</head>
<body>
	/** NavBar -Source -Destination -Date(Calendar) */
	<form action="showrunningbuses" method="post">
		<table>

			<tr>
				<td>Source</td>
				<td><input name="source" /></td>
			</tr>

			<tr>
				<td>Destination</td>
				<td><input name="destination" /></td>
			</tr>

			<tr>
				<td>Date(dd-MM-yyyy)</td>
				<td><input name="dateOfJourney" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>
	</form>
	<br><br>
	<jsp:include page="showRunningBuses.jsp" />
</body>
</html>