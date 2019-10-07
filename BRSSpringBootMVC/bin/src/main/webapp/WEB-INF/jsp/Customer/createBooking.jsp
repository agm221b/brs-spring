<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="create"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="show"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus details: </title>
</head>
<body>
Bus details:
<table border=1 style="table-hover">
<tr>
<td>Bus Id</td>
<td>Bus Name</td>
<td>Bus Type</td>
<td>Bus Class</td>
<td>Start Time</td>
<td>End Time</td>
</tr>
<show:forEach var="currentBusTransaction" items="${bus}">
<tr>
<td>${currentBusTransaction.getBus().getBusId() }</td>
<td>${currentBusTransaction.getBus().getBusName() }</td>
<td>${currentBusTransaction.getBus().getBusType() }</td>
<td>${currentBusTransaction.getBus().getBusClass() }</td>
<td>${currentBusTransaction.getBus().getStartTime() }</td>
<td>${currentBusTransaction.getBus().getEndTime() }</td>

</tr>
</show:forEach>
</table>


<br/>

<a href="addpassenger"> <input type="button"
				class="waves-effect waves-light btn" value="Add Passenger"></a>

<jsp:include page="../linklib.jsp" />
</body>
</html>