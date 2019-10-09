<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="search"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="css/customer.css">


</head>
<c:url value="/img/" var="images"></c:url>
<body>
	<!-- /** NavBar -Source -Destination -Date(Calendar) */ -->
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="customerhome">BusNama</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="customerhome">Home</a></li>
    </ul>
  </div>
</nav>
	<br>
	<search:form method="post" action="showrunningbuses" modelAttribute="bus" id="searchbusform">
	
				 <span style="color: red;"></span>
			<br>
				
			
				 
			
			<table class="striped" style="padding: 20px;">
			
			<tr>
			<td><label for="source">Source</label> 
			</td>
			</tr>
			
			<tr>
			<td><search:select cssClass="form-control" path="source" items="${src }" id="source"/>
			</td>
			</tr>
			
			<tr>
			<td><label for="destination">Destination</label>  <search:select cssClass="form-control" path="destination" items="${dest }" id="destination"/>
			</td>
			</tr>
			
			
			</table>
			<br>
			<div class="input-field col s6">
				<!-- to work on datepicker  -->
				<label for="datepicker">Enter date:</label> <input type="text"
					name="date_of_journey" id="datepicker" /> <span
					style="color: red;"></span>
			</div>
			<div id="section">
			<script>
			$('#datepicker').datepicker({
				dateFormat: 'dd-mm-yy'
			});
			</script>
			</div>
			<br>
		<input type="submit" value="Search Buses" id="searchbuses">
		
		<script>
		$(document).ready(function(){
			$('#searchbuses').submit(function(event){
				event.preventDefault();
				var source=$('#source').val();
				var destination=$('#destination').val();
				
				$('.route_error').remove();
				
				if(source===destination){
					$('#source').after('<span class="route_error">Source and Destination cannot be same</span>');
					$('#destination').after('<span class="route_error">Source and Destination cannot be same</span>');
				}
				
				var dateOfJourney=$('#datepicker').val();
				
				var journeydate=new Date(dateOfJourney);
				var today=new Date();
				console.log(Date.parse(journeydate));
				console.log(Date.parse(today));
				if(Date.parse(journeydate)<Date.parse(today)){
					$('#searchbuses').after('<span class="date_error">Date should be in the future</span>')
				}
			});
		});
		</script>
	</search:form>
	<br />
	<h4>List Of Running Buses</h4>
	<jsp:include page="showRunningBuses.jsp"></jsp:include>
	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>