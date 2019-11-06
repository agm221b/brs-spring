<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.cg.BrsSpringBootMVC.dto.Passenger" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.13.1/validate.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="customerhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="customerhome">Home</a></li>
				<li><a href="help">FAQs</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="viewallbookings">View All Bookings</a></li>
						<li><a href="#">Manage Profile</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
	
	<table>
		<form:form action="addpassengerdetails" method="POST" modelAttribute="passenger" id="passenger_form">
			<tr>
				<td>Passenger Name</td>
				<td><form:input path="passengerName" id="passenger_name" name="passenger_name" required="required" pattern="^[a-zA-Z\s]+$" title="Passenger Name should contain only alphabetical characters."/></td>
				<td><span style="color:red;"><form:errors path="passengerName"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Age</td>
				<td><form:input path="passengerAge" id="passenger_age" name="passenger_age" required="required" pattern="^[1-7]{1}[0-9]{1}$" title="Passenger age is not a number."/></td>
				<td><span style="color:red;"><form:errors path="passengerAge"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Gender</td>
				<td>
					<p>
						<label> <form:radiobutton path="passengerGender" value="M" name="passenger_gender" checked="checked"/>
							<span>Male</span>
						</label>
					</p>
					<p>
						<label> <form:radiobutton path="passengerGender" value="F" name="passenger_gender"/>
							<span>Female</span>
						</label>
					</p>
				</td>
				<td><span style="color:red;"><form:errors path="passengerGender"
							delimiter=","></form:errors></span></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add" id="addpassenger"><%session.getAttribute("transactionId"); %></td>

				<td><input type="reset" value="Clear"></td>
				<td>
				<a href="confirmation"> <input type="button"
				class="waves-effect waves-light btn" value="Proceed"></a>
				</td>

			</tr>
		</form:form>
	
	</table>
	<script>
	</script>
	<jsp:include page="ShowPassengerList.jsp" />
	<jsp:include page="../linklib.jsp" />
	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>