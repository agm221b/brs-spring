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
<addbus:form action="addBusDetails" method="post" modelAttribute="bus_details">
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
<td><addbus:radiobutton path="busType"/>Sleeper
<addbus:radiobutton path="busType"/>Semi-Sleeper
</td>
</tr>
<tr>
<td>Bus Class</td>
<td><addbus:radiobutton path="busClass"/>Sleeper
<addbus:radiobutton path="busClass"/>Semi-Sleeper
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
<td><input type="time" name="startTime"></td>
</tr>
</table>
</addbus:form>
</body>
</html>