<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>

</head>
<body>

	/** NavBar -Source -Destination -Date(Calendar) */
	<table>
		<form:form action="addpassengerdetails" method="POST" modelAttribute="passenger">
			<tr>
				<td>Passenger Name</td>
				<td><form:input path="passengerName" /></td>
				<td><span><form:errors path="passengerName"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Age</td>
				<td><form:input path="passengerAge" /></td>
				<td><span><form:errors path="passengerAge"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Gender</td>
				<td><form:radiobutton path="passengerGender" value='M'/>Male
				<form:radiobutton path="passengerGender" value='F'/>Female
				</td>
				<td><span><form:errors path="passengerGender"
							delimiter=","></form:errors></span></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add"></td>
				<td><a href="confirmation"> <input type="button"
						value="Proceed" />
				</a>
			</tr>
		</form:form>
	</table>

	<jsp:include page="ShowPassengerList.jsp" />
	<jsp:include page="../linklib.jsp" />

</body>
</html>