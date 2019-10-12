<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

	<div class="row">
		<form:form class="col s6" action="adduser" method="post" modelAttribute="user">
			<div class="row">
				<div class="input-field col s6">
					<form:hidden path="userId"/>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Username" type="text"
						 path="username" pattern="^[a-zA-Z\s]{3,20}$" title="username allows any character from A-Z, a-z and space, with min and max length of 3 and 20 respectively. " required="required"/> <label for="username">Username</label>
						<span style="color:red;"><form:errors path="username"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Password" type="password"  path="pass" required="required" pattern="\\S{8,}" title="password should atleast have 8 characters"/> <label
						for="password">Password</label>
						<span style="color:red;"><form:errors path="pass"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input id="email" type="email" class="validate" path="email" pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$"
							required="required" /> <label
						for="email">Email</label>
						<span style="color:red;"><form:errors path="email"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Phone Number" id="phoneNumber" type="text"
						class="validate" path="phoneNumber" required="required" title="phone number should be of 10 digits"/> <label for="username">Phone Number</label>
						<span style="color:red;"><form:errors path="phoneNumber"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<p>
						<label> <form:radiobutton path="userType" value="A" />
							<span>Admin</span>
						</label>
					</p>
					<p>
						<label> <form:radiobutton path="userType" value="C" checked="checked"/>
							<span>Customer</span>
						</label>
						<span style="color:red;"><form:errors path="userType"></form:errors></span>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input type="submit" class="waves-effect waves-light btn"/><br>
				</div>
			</div>
		</form:form>
	</div>
	<jsp:include page="linklib.jsp"></jsp:include>
	<jsp:include page="../webjar/jsp/footer.jsp"></jsp:include>
	
</body>
</html>