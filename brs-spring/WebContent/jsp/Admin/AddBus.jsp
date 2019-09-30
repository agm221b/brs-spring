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
<td><span style="color:red;"><addbus:errors path="busName"></addbus:errors></span></td>
</tr>
<tr>
<td>Bus Type</td>
<td><%-- <addbus:radiobutton path="busType" value="SLEEPER"/>Sleeper
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
<td><%-- <addbus:radiobutton path="busClass" value="AC"/>AC
<addbus:radiobutton path="busClass" value="NON_AC"/>Non-AC --%>
	<p>
      <label>
        <addbus:radiobutton path="busClass" value="AC"  />
        <span>AC</span>
      </label>
    </p>
    <p>
      <label>
        <addbus:radiobutton path="busClass" value="NON_AC" />
        <span>Non-AC</span>
      </label>
    </p>
</td>
</tr>
<tr>
<td>Bus Source</td>
<td><addbus:input path="source"/></td>
<td><span style="color:red;"><addbus:errors path="source"></addbus:errors></span></td>
</tr>
<tr>
<td>Bus Destination</td>
<td><addbus:input path="destination"/></td>
<td><span style="color:red;"><addbus:errors path="destination"></addbus:errors></span></td>
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
<td><span style="color:red;"><addbus:errors path="noOfSeats"></addbus:errors></span></td>
</tr>
<tr>
<td>Cost per seat</td>
<td><addbus:input path="costPerSeat"/></td>
<td><span style="color:red;"><addbus:errors path="CostPerSeat"></addbus:errors></span></td>
</tr>
</table>
<input type="submit" value="Add"/>
</addbus:form>

<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>