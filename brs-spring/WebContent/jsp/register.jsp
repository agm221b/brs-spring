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
					<form:input placeholder="Username" type="text"
						 path="username"/> <label for="username">Username</label>
						<span style="color:red;"><form:errors path="username"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Password" type="password"  path="pass" /> <label
						for="password">Password</label>
						<span style="color:red;"><form:errors path="pass"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input id="email" type="email" class="validate" path="email" /> <label
						for="email">Email</label>
						<span style="color:red;"><form:errors path="email"></form:errors></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Phone Number" id="phoneNumber" type="number"
						class="validate" path="phoneNumber" /> <label for="username">Phone Number</label>
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
						<label> <form:radiobutton path="userType" value="C" />
							<span>Customer</span>
						</label>
						<span style="color:red;"><form:errors path="userType"></form:errors></span>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input type="submit" class="waves-effect waves-light btn">Add User</a><br>
				</div>
			</div>
		</form:form>
	</div>
	<jsp:include page="linklib.jsp"></jsp:include>
	<jsp:include page="../webjar/jsp/footer.jsp"></jsp:include>
</body>
</html>