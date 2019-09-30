<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>


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
					<form:input placeholder="Username" id="username" type="text"
						class="validate" path="username"/> <label for="username">Username</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Password" id="password" type="password" class="validate" path="pass" /> <label
						for="password">Password</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input id="email" type="email" class="validate" path="email" /> <label
						for="email">Email</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Phone Number" id="phoneNumber" type="number"
						class="validate" path="phoneNumber" /> <label for="username">Phone Number</label>
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
						<label> <form:radiobutton path="userType" value="C" />
							<span>Customer</span>
						</label>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<a class="waves-effect waves-light btn" href="adduser">Add User</a><br>
				</div>
			</div>
		</form:form>
	</div>
	<jsp:include page="linklib.jsp"></jsp:include>
</body>
</html>