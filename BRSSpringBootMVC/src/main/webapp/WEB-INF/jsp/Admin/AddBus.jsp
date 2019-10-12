<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="addbus"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bus</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.js"></script>
	

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="adminhome">Home</a></li>
			</ul>
		</div>
	</nav>
	Enter bus details
	<addbus:form id="addbusform" class="col s6" action="addbusdetails"
		method="post" modelAttribute="bus">
		<table>
			<tr>
				<td></td>
				<td><addbus:hidden path="busId" /></td>
			</tr>
			<tr>
				<td>Bus Name</td>
				<td><addbus:input path="busName" placeholder="Bus Name"
						id="busName" type="text" class="validate" /></td>
				<td><span id="busNameerror" style="color: red;"><addbus:errors
							path="busName" id="busNameerror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Bus Type</td>
				<td>
					<%-- <addbus:radiobutton path="busType" value="SLEEPER"/>Sleeper
<addbus:radiobutton path="busType" value="SEMI_SLEEPER"/>Semi-Sleeper --%>
					<addbus:select class="browser-default" path="busType">
						<option value="" disabled selected>Choose your option</option>
						<option value="SLEEPER">SLEEPER</option>
						<option value="SEMI_SLEEPER">SEMI-SLEEPER</option>
					</addbus:select>
				</td>
			</tr>
			<tr>
				<td>Bus Class</td>
				<td>
					<%-- <addbus:radiobutton path="busClass" value="AC"/>AC
<addbus:radiobutton path="busClass" value="NON_AC"/>Non-AC --%>
					<p>
						<label> <addbus:radiobutton path="busClass" value="AC" />
							<span>AC</span>
						</label>
					</p>
					<p>
						<label> <addbus:radiobutton path="busClass" value="NON_AC" />
							<span>Non-AC</span>
						</label>
					</p>
				</td>
			</tr>
			<tr>
				<td>Bus Source</td>
				<td><addbus:input path="source" id="source" name="source" /></td>
				<td><span style="color: red;"><addbus:errors
							path="source" id="sourceError"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Bus Destination</td>
				<td><addbus:input path="destination" id="destination"  /></td>
				<td><span style="color: red;"><addbus:errors
							path="destination" id="destinationError"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Start time</td>
				<td><input type="time" id="startTime" name="startTime"><span
					style="color: red;"><addbus:errors path="startTime"
							id="startTimeerror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>End time</td>
				<td><input type="time" name="endTime" id="endTime"><span
					style="color: red;"><addbus:errors path="endTime"
							id="endTimeerror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Number of Seats</td>
				<td><addbus:input path="noOfSeats" id="noOfSeats" /></td>
				<td><span style="color: red;"><addbus:errors
							path="noOfSeats" id="seaterror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Cost per seat</td>
				<td><addbus:input path="costPerSeat" id="costPerSeat" /></td>
				<td><span style="color: red;"><addbus:errors
							path="costPerSeat" id="costerror"></addbus:errors></span></td>
			</tr>
		</table>
		<p style="color: red;" id="error">
			<c:out value="${modelError}" />
		</p>
		<input type="submit" value="Add" />

	</addbus:form>
	
	<script type="text/javascript">


	$(document).ready(function() {  // <-- enclose your code in a DOM ready handler

	    $("#addbusform").validate({
	        rules: {
	            "busName": { // <-- assign by field name and use quotes
	                required: true,
	                minlength: 6,
	                maxlength: 40
	            },
	            "busType": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "busClass": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "source": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "destination": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "startTime": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "endTime": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "noOfSeats": { // <-- assign by field name and use quotes
	                required: true,
	            },
	            "costPerSeat": {
	                required: true,
	            }
	        },
	        messages: {
	            "busName": {
	                required: "Bus Name is required!",
	                minlength: "Bus Name must be at least 6 characters long"
	            },
	            "busType": {
	                required: "Bus Type is required!",
	                
	            },
	            "busClass": {
	                required: "Bus Class is required!",
	                
	            },
	            "source": {
	                required: "Source is required!",
	                
	            },
	            "destination": {
	                required: "Destination is required!",
	                
	            },
	            "startTime": {
	                required: "Start Time is required!",
	                
	            },
	            "endTime": {
	                required: "End Time is required!",
	                
	            },
	            "noOfSeats": {
	                required: "No of Seats is required!",
	                
	            },
	            "costPerSeat": {
	                required: "Cost Per Seat is required!",
	                
	            },
	            
	        }
	        /*, // submitHandler is not needed for this case
	        submitHandler: function (form) {
	            form.submit();  // <-- this is the default
	        }
	        */
	    });

	});

	</script>

	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>