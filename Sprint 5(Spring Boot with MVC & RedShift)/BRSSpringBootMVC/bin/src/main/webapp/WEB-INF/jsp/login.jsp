<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
#main{
background-color: white;
height: 400px;
width: 600px;
}

#userform{
padding-left: 175px;
}

#submitbtn{
text-align: center;
}

h3{
text-align:center;
}

</style>
</head>
<body style="background-color: #fff9c4;">
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

	<div class="container" id="main">
	<h3>Login Form</h3>
	<c:if test="${not empty errorMessage}">
						<div style="color: red; font-weight: bold; margin: 30px 0px;">${errorMessage}</div>
					</c:if>
		<form id="userform" class="col s6" action="login" method="post">
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="Username" type="text" name="username"
						required="required"> <label for="username">Username</label>
					<span style="color: red;"></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="Password" type="password" name="password"
						required="required"> <label for="password">Password</label>
					<span style="color: red;"></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6" id="submitbtn">
					<input type="submit" class="waves-effect waves-light btn"
						value="LOGIN" ><br> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</div>
		</form>
		${errormessage }
	</div>

	<jsp:include page="linklib.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>