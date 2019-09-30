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
	/** NavBar -Source -Destination -Date(Calendar) */
	<search:form method="post" action="showrunningbuses">
Source:<input type="text" name="source" />
Destination:<input type="text" name="destination" />
Date Of Journey:<input type="date" name="date_of_journey" />
		<input type="submit" value="Search Buses">
	</search:form>
	<br />
	<h2>List Of Running Buses</h2>
	<jsp:include page="showRunningBuses.jsp"></jsp:include>

</body>
</html>