<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="show"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Running Buses</title>
</head>
<body>
<table border=1 style="table-bordered">
<tr>
<th>Bus Id</th>
<th>Bus Name</th>
<th>Bus Type</th>
<th>Bus Class</th>
<th>Cost Per Seat</th>
<th>Start time</th>
<th>End time</th>
<th>Available Seats</th>
<th></th>
</tr>
<show:forEach var="transaction" items="${transactionList}">
<tr>    
<td>${transaction.getBus().getBusId()}</td>
<td>${transaction.getBus().getBusName()}</td>
<td>${transaction.getBus().getBusType()}</td>
<td>${transaction.getBus().getBusClass()}</td>
<td>${transaction.getBus().getCostPerSeat()}</td>
<td>${transaction.getBus().getStartTime()}</td>
<td>${transaction.getBus().getEndTime()}</td>
<td>${transaction.getAvailableSeats()}</td>
<td>
<a href="createbooking?transactionId=${transaction.getTransactionId()}"> <input type="button"
				class="waves-effect waves-light btn" value="Book"></a>
</td>

</tr>
</show:forEach>
</table>

<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>