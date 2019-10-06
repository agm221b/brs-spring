<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<h1>Greeting : ${greetMsg}</h1>
 <spring:url value="/report" var="xlsURL"></spring:url>
 <a href="${xlsURL}">Get in Excel</a>

<jsp:include page="linklib.jsp"></jsp:include>

</body>
</html>