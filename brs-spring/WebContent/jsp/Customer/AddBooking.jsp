<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>


</head>
<body>
/**
NavBar
-Source
-Destination
-Date(Calendar)

*/
	<table>
		<form:form action="pagesubmit" method="POST" modelAttribute="model">
			<tr>
				<td>Source</td>
				<td><form:input path="source" /></td>
				<td><span><form:errors path="source"></form:errors></span></td>
			</tr>
			
			<tr>
				<td>Destination</td>
				<td><form:input path="destination" /></td>
				<td><span><form:errors path="destination" delimiter=","></form:errors></span></td>
			</tr>

			<tr>
				<td>Date</td>
				<td><form:input path="date" /></td>
				<td><span><form:errors path="date"></form:errors></span></td>
			</tr>
			
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</form:form>
	</table>
	
	<jsp:include page="ShowBusList.jsp"/>
</body>
</html>