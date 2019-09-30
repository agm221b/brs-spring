<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tab" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Passengers</title>
</head>
<body>

<h2>Passenger Details</h2>
	<table border="1">
		<tr>
			<th>Passenger Name</th>
			<th>Passenger Age</th>
			<th>Passenger Gender</th>
		</tr>

		<tab:forEach var="pass" items="${passengerList}">
			<tr>
				<td>${pass.passngerName}</td>
				<td>${pass.passengerAge}</td>
				<td>${pass.passengerGender}</td>
				<td></button> </td>
			</tr>
		</tab:forEach>

	</table>
</body>
</html>