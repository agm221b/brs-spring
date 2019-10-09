<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="addbus"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bus</title>
<script type="text/javascript">
function validate(){
	var f= document.getElementById("addbusform");
	validateBusName(f);
	validateStartTime(f);
	validateEndTime(f);
	validateNoOfSeats(f);
	validateCostOfSeats(f);
}

function validateBusName(busform){
	
	var error = document.getElementById("busNameerror");
	var busName = busform["busName"].value;
	error.innerHTML="";
	var regex=/[\]+/g;
	var validUsername = busName.match(regex)

	   if( busName==null || busName==""){
	      error.innerHTML="Bus Name cannot be empty";
	    }
	   else if(validUsername != null){
	        alert("Your Bus Name is not valid");
	        document.frm.firstName.focus();
	   }
	   else if(busName.length<5 || busName.length>15){
	        error.innerHTML="Bus Name has to be 5 to 15 chars"
	    }
}

function validateStartTime(busform){
	
	var error = document.getElementById("startTimeerror");
	var startTime = busform["startTime"].value;
	error.innerHTML="";
	
	if( startTime==null || startTime==""){
	      error.innerHTML="Start Time cannot be empty";
	    }
	
}

function validateEndTime(busform){
	
	var error = document.getElementById("endTimeerror");
	var endTime = busform["endTime"].value;
	error.innerHTML="";
	
	if( endTime==null || endTime==""){
	      error.innerHTML="End Time cannot be empty";
	    }
	
}

function validateNoOfSeats(busform){
	
	var error = document.getElementById("seaterror");
	var noOfSeats = busform["noOfSeats"].value;
	error.innerHTML="";
	

		if(noOfSeats<=0){
		   error.innerHTML = "seats cannot be less than or equal to zero";
	   	}
		else if(noOfSeats>=99){
		   error.innerHTML = "cost exceeds max value";
	   	}
	  	 else if(isNan(noOfSeats)){
		   error.innerHTML="Seats is not a number, enter a number";
	   	}
	
}

function validateCostOfSeats(busform){
	
	var error = document.getElementById("costerror");
	var costPerSeat = busform["costPerSeat"].value;
	error.innerHTML="";
	

	   if(costPerSeat<=0){
		   error.innerHTML = "cost cannot be less than or equal to zero";
	   }
	   else if(costPerSeat>=9999){
		   error.innerHTML = "cost exceeds max value";
	   }
	   else if(isNan(costPerSeat)){
		   error.innerHTML="Cost is not a number, enter a number";
	   }
}

</script>

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
							path="busName"></addbus:errors></span></td>
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
				<td><addbus:input path="source" /></td>
				<td><span style="color: red;"><addbus:errors
							path="source"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Bus Destination</td>
				<td><addbus:input path="destination" /></td>
				<td><span style="color: red;"><addbus:errors
							path="destination"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Start time</td>
				<td><input type="time" id="startTime" name="startTime"></td>
			</tr>
			<tr>
				<td>End time</td>
				<td><input type="time" name="endTime"></td>
			</tr>
			<tr>
				<td>Number of Seats</td>
				<td><addbus:input path="noOfSeats" id="noOfSeats" /></td>
				<td><span style="color: red;"><addbus:errors
							path="noOfSeats"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Cost per seat</td>
				<td><addbus:input path="costPerSeat" id="costPerSeat" /></td>
				<td><span style="color: red;"><addbus:errors
							path="CostPerSeat"></addbus:errors></span></td>
			</tr>
		</table>
		<input type="submit" value="Add" />
	</addbus:form>

	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>