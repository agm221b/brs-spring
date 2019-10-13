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
<body style="background-color: #fff9c4;">
	<!-- /** NavBar -Source -Destination -Date(Calendar) */ -->
	<nav class="navbar navbar-inverse" style="height: auto;">
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
			 <ul class="nav navbar-nav navbar-right">
			 <li><a href="<%=request.getContextPath()%>/logout"><input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" /><button style="color:white;background-color:#e57373">Logout</button></a></li>
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
				dateFormat: 'dd-mm-yy',
				minDate: -1,
				maxDate: +15
			});
			</script>
			</div>
			<br>
		<input type="submit" value="Search Buses" id="searchbuses">
		
		<script>
		$(document).ready(function(){
			
			function checkSearchBusForm(){
				//gets the source value from dropdown
				var source=$('#source').val();
				//gets the destination value from dropdown
				var destination=$('#destination').val();
				
				$('.route_error').remove();
				
				if(source===destination){
					$('#source').after('<span class="route_error">Source and Destination cannot be same</span>');
					$('#destination').after('<span class="route_error">Source and Destination cannot be same</span>');
					return false;
				}
				return true;
			}
			
			$('#searchbuses').click(function(event){
				if(checkSearchBusForm()==true){
					$('#searchbusform').submit();
				}else{
					event.preventDefault();
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