<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>
<<<<<<< HEAD
<link rel="stylesheet" href="css/customer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
=======
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
>>>>>>> branch 'master' of https://github.com/agm221b/brs-spring.git
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
<<<<<<< HEAD
		function validatePassengerName(){
			var passengerName=$('#passenger_name').val();
			var nameRegExp=/^\w+\s*$/;
			
			if(passengerName.length < 1){
				$('#passenger_name').after("<span class='passenger_error'>Passenger name is empty</span>");
				return false;
			}
			
			if(!(nameRegExp.test(passengerName))){
				$('#passenger_name').after("<span class='passenger_error'>Passenger name should contain only alphabetical characters</span>");
				return false;
			}
			
		}
		$('#addpassenger').click(function(event){
			if(validatePassengerName()==true){
				$('passenger_form').submit();
			}
			else{
				event.preventDefault();
			}
		});
	});
=======
// 		$('#passenger_form').submit(function(event){
// 			event.preventDefault();
			
// 			$('.passenger_error').remove();
			
// 			var passengerName=$('#passenger_name').val();
// 			var passengerAge=$('#passenger_age').val();
// 			var passengerGender=$('radiobutton[name="passenger_gender"]:checked').val();
			
// 			var nameRegEx=/^\w+\s?$/;
// 			var ageRegEx=/^\d[1,2]$/;
			
// 			var validName=nameRegEx.test(passengerName);
// 			var validAge=ageRegEx.test(passengerAge);
			
// 			console.log(passengerName);
// 			console.log(passengerAge);
// 			console.log(passengerGender);
			
// 			if(passengerName.length<1){
// 				$('#passenger_name').after("<span class='passenger_error'>Passenger Name Is Empty</span><br>")
// 			}
// 			if(passengerAge<0){
// 				$('#passenger_age').after("<span class='passenger_error'>Passenger Age Is Invalid</span>");
// 			}
// 			if(passengerGender!='M'||passengerGender!='F'){
// 				$('radiobutton[name="passenger_gender"]').after("<span class='passenger_error'>Select Gender</span>")
// 			}
// 			if(!validName){
// 				$('#passenger_name').after("<span class='passenger_error'>Passenger Name Is Invalid</span>")
// 			}
// 			if(!validAge){
// 				$('#passenger_age').after("<span class='passenger_error'>Passenger Age Is Invalid</span>")
// 			}
// 		});
// 	});
>>>>>>> branch 'master' of https://github.com/agm221b/brs-spring.git
	</script>
	<jsp:include page="ShowPassengerList.jsp" />
	<jsp:include page="../linklib.jsp" />
</body>
</html>