<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
</head>
<body>

	/** NavBar -Source -Destination -Date(Calendar) */
	<table>
		<form:form action="addpassengerdetails" method="POST"
			modelAttribute="passenger">
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
				<td><form:input path="passengerGender" /></td>
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

</body>
</html>