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
	
<style type="text/css">
#busform{
background-color:white;
height: 90%;
}

#addbtn{
text-align:center;
}

h3{
text-align:center;
}
</style>
</head>
<body style="background-color: #fff9c4;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="adminhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="adminhome">Home</a></li>
			</ul>
			<ul class="nav navbar-nav right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout" class="btn btn-danger"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
	<div class="container" id="busform">
	<h3>Enter bus details</h3>
		<p style="color: red;" id="error">
			<b><c:out value="${modelError}" /></b>
		</p>
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
						id="busName" type="text" class="validate" required="required" pattern="^[A-Za-z\s]+$" title="Bus name should contain
						alphabetical characters"/></td>
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
						<label> <addbus:radiobutton path="busClass" value="AC" checked="checked"/>
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
				<td><addbus:input path="source" id="source" name="source" required="required" pattern="^[A-Za-z]+" title="Source should contain
				alphabetical characters"/></td>
				<td><span style="color: red;"><addbus:errors
							path="source" id="sourceError"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Bus Destination</td>
				<td><addbus:input path="destination" id="destination" required="required" pattern="^[A-Za-z]+" title="Destination should contain
				alphabetical characters"/></td>
				<td><span style="color: red;"><addbus:errors
							path="destination" id="destinationError"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Start time</td>
				<td><input type="time" id="startTime" name="startTime" required="required"><span
					style="color: red;"><addbus:errors path="startTime"
							id="startTimeerror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>End time</td>
				<td><input type="time" name="endTime" id="endTime" required="required"><span
					style="color: red;"><addbus:errors path="endTime"
							id="endTimeerror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Number of Seats</td>
				<td><addbus:input path="noOfSeats" id="noOfSeats" required="required" pattern="^[1-4]{1}[0-9]{1}$"/></td>
				<td><span style="color: red;"><addbus:errors
							path="noOfSeats" id="seaterror"></addbus:errors></span></td>
			</tr>
			<tr>
				<td>Cost per seat</td>
				<td><addbus:input path="costPerSeat" id="costPerSeat" required="required"/></td>
				<td><span style="color: red;"><addbus:errors
							path="costPerSeat" id="costerror"></addbus:errors></span></td>
			</tr>
		</table>
	
		<div id="addbtn"><input type="submit" value="Add" class="btn btn-info" /></div>

	</addbus:form>
	</div>
	<jsp:include page="../linklib.jsp"></jsp:include>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>