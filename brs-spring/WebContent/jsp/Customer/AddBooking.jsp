<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="search"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>


</head>
<body>
	<!-- /** NavBar -Source -Destination -Date(Calendar) */ -->
	<br>
	<search:form method="post" action="showrunningbuses">
		<p>
			<label for="source">Source</label> <input id="source" type="text"
				class="validate" name="source">
		</p>
		<br>
		<p>
			<label for="destination">Destination</label> <input id="destination"
				type="text" class="validate" name="destination">

		</p>
		<br>
		<p>																					<!-- to work on datepicker  -->
			<label for="datepicker">Enter date:</label> <input type="date"
				class="datepicker" id="datepicker" name="date_of_journey"/>
		</p>
		<br>
		
		<div class="section">
			

			<script>
				$(function() {
					$(".datepicker").datepicker();
				});
			</script>

		</div>
		<input type="submit" value="Search Buses">
	</search:form>
	<br />
	<h2>List Of Running Buses</h2>
	<jsp:include page="showRunningBuses.jsp"></jsp:include>
	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>