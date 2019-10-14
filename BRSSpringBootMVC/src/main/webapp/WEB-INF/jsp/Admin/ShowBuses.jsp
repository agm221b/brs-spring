<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tab" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Buses</title>
<style type="text/css">

#busList{
background-color: white;
}
</style>
</head>
<body style="background-color: #fff9c4;">
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="adminhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="adminhome">Home</a></li>
			</ul>
			<ul class="nav navbar-nav right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout" class="btn btn-danger"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
	<div class="container" id="busList">
	<h3>Here are the list of buses :-</h3>
	<table border="1">
		<tr>

			<th>Bus ID</th>
			<th>Bus Name</th>
			<th>Bus Type</th>
			<th>Bus Class</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Seats</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Cost Per Seat</th>
<!-- 			<th>Edit</th> -->
			<th>Delete</th>
		</tr>

		<tab:forEach var="bus" items="${busList}">
			<tr>
				<td>${bus.busId}</td>
				<td>${bus.busName}</td>
				<td>${bus.busType}</td>
				<td>${bus.busClass}</td>
				<td>${bus.source}</td>
				<td>${bus.destination}</td>
				<td>${bus.noOfSeats}</td>
				<td>${bus.startTime}</td>
				<td>${bus.endTime}</td>
				<td>${bus.costPerSeat}</td>


				<%-- <td><a href="modifybus?busId=${bus.getBusId()}"> <input type="button" value="Edit" /></a> --%>
				<td><a href="deletebus?busId=${bus.getBusId()}"> <input type="button"
						value="Delete" /></a>
			</tr>
		</tab:forEach>

	</table>
	</div>
	

	<jsp:include page="../linklib.jsp"></jsp:include>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>