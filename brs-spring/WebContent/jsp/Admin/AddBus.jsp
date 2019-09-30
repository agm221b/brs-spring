<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="addbus" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bus</title>


</head>
<body>
Enter bus details
<addbus:form action="addbusdetails" method="post" modelAttribute="bus">
<table>
<tr>
<td></td>
<td><addbus:hidden path="busId"/></td>
</tr>
<tr>
<td>Bus Name</td>
<td><addbus:input path="busName"/></td>
</tr>
<tr>
<td>Bus Type</td>
<td><addbus:radiobutton path="busType" value="SLEEPER"/>Sleeper
<addbus:radiobutton path="busType" value="SEMI_SLEEPER"/>Semi-Sleeper
</td>
</tr>
<tr>
<td>Bus Class</td>
<td><addbus:radiobutton path="busClass" value="AC"/>AC
<addbus:radiobutton path="busClass" value="NON_AC"/>Non-AC
</td>
</tr>
<tr>
<td>Bus Source</td>
<td><addbus:input path="source"/></td>
</tr>
<tr>
<td>Bus Destination</td>
<td><addbus:input path="destination"/></td>
</tr>
<tr>
<td>Start time</td>
<td><input type="time" name="startTime"></td>
</tr>
<tr>
<td>End time</td>
<td><input type="time" name="endTime"></td>
</tr>
<tr>
<td>Number of Seats</td>
<td><addbus:input path="noOfSeats"/></td>
</tr>
<tr>
<td>Cost per seat</td>
<td><addbus:input path="costPerSeat"/></td>
</tr>
</table>
<input type="submit" value="Add"/>
</addbus:form>

<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>