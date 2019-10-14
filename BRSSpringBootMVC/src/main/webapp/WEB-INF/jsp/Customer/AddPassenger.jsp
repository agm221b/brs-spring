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
				<td><form:input path="passengerName" id="passenger_name" name="passenger_name"/></td>
				<td><span style="color:red;"><form:errors path="passengerName"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Age</td>
				<td><form:input path="passengerAge" id="passenger_age" name="passenger_age"/></td>
				<td><span style="color:red;"><form:errors path="passengerAge"></form:errors></span></td>
			</tr>

			<tr>
				<td>Passenger Gender</td>
				<td>
					<p>
						<label> <form:radiobutton path="passengerGender" value="M" name="passenger_gender" />
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
 	$(document).ready(function(){
 		$('#passenger_form').submit(function(event){
 			event.preventDefault();
 			$('.passenger_error').remove();
			
 			var passengerName=$('#passenger_name').val();
 			var passengerAge=$('#passenger_age').val();
 			var passengerGender=$('radiobutton[name="passenger_gender"]:checked').val();
			
			
 			if(passengerName.length < 1){
 				$('#passenger_name').after("<span class='passenger_error'>Passenger name is empty</span><br>");
 			}else{
 				var nameRegExp=/^[A-Z]*[a-z]+$/;
 				var validPassengerName=nameRegExp.test(passengerName);
 				if(!validPassengerName){
 					$('#passenger_name').after("<span class='passenger_error'>Passenger name should contain only alphabetical characters</span><br>");
 				}
 			}
 			
 			if(passengerAge.length <1){
 				$('#passenger_age').after("<span class='passenger_error'>Passenger age is empty</span><br>");
 			}else{
 				if(passengerAge<0 && passenger>70){
 					$('#passenger_age').after("<span class='passenger_error'>Passenger age is invalid</span><br>");
 				}
 			}
 			
 			if(passengerGender===""){
 				$('radiobutton[name="passenger_gender"]').after("<span class='passenger_error'>Passenger gender is not selected</span><br>");
 			} 			
 		});
});
	</script>
	<jsp:include page="ShowPassengerList.jsp" />
	<jsp:include page="../linklib.jsp" />

</body>
</html>