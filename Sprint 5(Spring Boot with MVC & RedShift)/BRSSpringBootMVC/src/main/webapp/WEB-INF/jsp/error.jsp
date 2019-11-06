<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>

<style type="text/css">

section.center{
align-items: center;
padding: 1%;
padding-left: 20%;
padding-right: 20%;

} 
</style>

</head>
<body style="background-color: #fff8e1;">
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				</ul>
		</div>
	</nav>
	<section class="center">

<h1 style="color: red;" >Error Page </h1>


	<c:if test="${empty ErrorMsg}">
		<h1>System Errors - Bad Request</h1>
	</c:if>

	<c:if test="${not empty ErrorMsg}">
		<h2>${ErrorMsg}</h2>
	</c:if>
	
	<img src="img/bus_gif.gif">
	
	</section>
	
	<jsp:include page="linklib.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>