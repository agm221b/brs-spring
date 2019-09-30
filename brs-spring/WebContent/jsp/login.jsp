<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="login" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>


</head>
<body>
Enter Login Details
<login:form method="post" action="loginVerify" modelAttribute="login_details">
<table>
<tr>Username</tr>
</table>
</login:form>
<jsp:include page="linklib.jsp"></jsp:include>
</body>
</html>