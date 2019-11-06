<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tab" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Users</title>

<style type="text/css">

#userList{
background-color: white;
}
</style>
</head>
<body style="background-color: #fff9c4;">
<jsp:include page="../linklib.jsp"></jsp:include>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="adminhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="adminhome">Home</a></li>
			</ul>
			<ul class="nav navbar-nav right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout" class="btn btn-danger"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
<div class="container" id="userList">
<h1>Here are the list of users:-</h1>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Username</th>
			<th>User Type</th>
			<th>Email</th>
			<th>Phone Number</th>
		</tr>

		<tab:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td>${user.userType}</td>
				<td>${user.email}</td>
				<td>${user.phoneNumber}</td>
			</tr>
		</tab:forEach>

	</table>
</div>


<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>