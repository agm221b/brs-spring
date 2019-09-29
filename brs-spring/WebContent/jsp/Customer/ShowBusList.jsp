<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tab" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Buses</title>
</head>
<body>

	<h1>Here are the list of buses running accordingly :-</h1>
	<table border="1">
		<tr>
			<th>Source</th>
			<th>Destination</th>
			<th>Bus ID</th>
			<th>Bus Name</th>
			<th>Available Seats</th>
			<th>Book</th>
		</tr>

		<tab:forEach var="trans" items="${transList}">
			<tr>
				<td>${trans.bus.source}</td>
				<td>${trans.bus.destination}</td>
				<td>${trans.bus.busId}</td>
				<td>${trans.busName}</td>
				<td>${trans.availableSeats}</td>
				<td><button value="Book" type="submit"></button> </td>
			</tr>
		</tab:forEach>

	</table>

</body>
</html>