<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="search"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>


</head>
<body>
	<!-- /** NavBar -Source -Destination -Date(Calendar) */ -->
	<br>
	<search:form method="post" action="showrunningbuses" modelAttribute="bus">
	
				 <span style="color: red;"></span>
			<br>
				
			
				 
			
			<table class="striped" style="padding: 20px;">
			
			<tr>
			<td><label for="source">Source</label> 
			</td>
			</tr>
			
			<tr>
			<td><search:select cssClass="form-control" path="source" items="${src }" />
			</td>
			</tr>
			
			<tr>
			<td><label for="destination">Destination</label>  <search:select cssClass="form-control" path="destination" items="${dest }" /> <span
					style="color: red;"></span>
			</td>
			</tr>
			
			
			</table>
			<br>
			<div class="input-field col s6">
				<!-- to work on datepicker  -->
				<label for="datepicker">Enter date:</label> <input type="date"
					name="date_of_journey" class="datepicker" id="datepicker" /> <span
					style="color: red;"></span>
			</div>
			<br>
		
		

		<div class="section">


			<script>
			$('.datepicker').datepicker({
			    format: 'mm/dd/yyyy',
			    startDate: '-3d'
			});
			</script>

		</div>
		<input type="submit" value="Search Buses">
	</search:form>
	<br />
	<h4>List Of Running Buses</h4>
	<jsp:include page="showRunningBuses.jsp"></jsp:include>
	<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>