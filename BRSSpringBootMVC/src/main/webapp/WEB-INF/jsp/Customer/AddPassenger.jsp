<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BusNama</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="customerhome">Home</a></li>
    </ul>
  </div>
</nav>
	
	<table>
		<form:form action="addpassengerdetails" method="POST" modelAttribute="passenger" id="passenger_form">
			<tr>
				<td>Passenger Name</td>
				<td><form:input path="passengerName" id="passenger_name"/></td>
				<td><span style="color:red;"><form:errors path="passengerName"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Age</td>
				<td><form:input path="passengerAge" id="passenger_age"/></td>
				<td><span style="color:red;"><form:errors path="passengerAge"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Gender</td>
				<td>
					<p>
						<label> <form:radiobutton path="passengerGender" value="M" id="passenger_gender"/>
							<span>Male</span>
						</label>
					</p>
					<p>
						<label> <form:radiobutton path="passengerGender" value="F" id="passenger_gender"/>
							<span>Female</span>
						</label>
					</p>
				</td>
				<td><span style="color:red;"><form:errors path="passengerGender"
							delimiter=","></form:errors></span></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add"><%session.getAttribute("transactionId"); %></td>

				<td><input type="reset" value="Clear"></td>
				<td>
				<a href="confirmation"> <input type="button"
				class="waves-effect waves-light btn" value="Proceed"></a>
				</td>

			</tr>
		</form:form>
	
	</table>
	<script>
	$(document).ready(function(){
		function validateForm(){
			
			var passengerName=$('#passenger_name').val();
			var passengerAge=$('passenger_age').val();
			var passengerGender=$('#passenger_gender').val();
			
			if(passengerName===''||passengerName==null){
				$('#passenger_name').after("<span class='passenger_error'>Passenger Name Is Empty</span>")
			}
			else if(passengerAge.isNaN()){
				$('#passenger_age').after("<span class='passenger_error'>Passenger Age Is Invalid</span>")
			}
			
		}
	});
	</script>
	<jsp:include page="ShowPassengerList.jsp" />
	<jsp:include page="../linklib.jsp" />

</body>
</html>