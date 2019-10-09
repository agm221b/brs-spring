<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Customer Home</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/customer.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="customerhome">BusName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="customerhome">Home</a></li>
      <li><a href="help">FAQs</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="addbooking">Book Ticket</a></li>
          <li><a href="viewallbookings">Manage Bookings</a></li>
          <li><a href="#">Manage Profile</a></li>
          <li><a href="logout">Logout</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
<h2><i>Welcome to BusNama </i><br></h2>
<a class="waves-effect waves-light btn" href="addbooking">Create Booking</a><br>
<br>
<a class="waves-effect waves-light btn" href="viewallbookings">View Bookings</a><br>
<br>
<a class="waves-effect waves-light btn" href="cancelbooking">Cancel Booking</a><br>
<br>
<a class="waves-effect waves-light btn" href="logout">Logout</a><br>

<div class="container"></div>

<jsp:include page="../linklib.jsp" />

</body>
</html>