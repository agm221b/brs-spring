<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>


</head>
<body>

<h2><i>Welcome to BusNama </i><br></h2>
<a class="waves-effect waves-light btn" href="addbus">Add Bus</a><br>
<a class="waves-effect waves-light btn" href="showbuses">Show All Buses</a><br>
<a class="waves-effect waves-light btn" href="showusers">Show All Users</a><br>
<form action="<%=request.getContextPath()%>/logout" method="POST">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
      </form> 

<jsp:include page="../linklib.jsp"></jsp:include>
</body>
</html>