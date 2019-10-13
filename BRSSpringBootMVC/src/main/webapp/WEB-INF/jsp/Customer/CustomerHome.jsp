<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="search"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Customer Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/customer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
#myCarousel{
	height: 700px;
	width: 100%;
}

#footer { 
            position: fixed; 
            padding: 10px 10px 0px 10px; 
            bottom: 0; 
            width: 100%; 
            /* Height of the footer*/  
            height: 40px; 
            background: orange; 
        } 

</style>

</head>
<body style="background: url(img/bus4.jpg); background-size: cover;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="customerhome">BusNama</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="customerhome">Home</a></li>
				<li><a href="help">FAQs</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="viewallbookings">View All Bookings</a></li>
						<li><a href="#">Manage Profile</a></li>
					</ul></li>
				<li><form action="<%=request.getContextPath()%>/logout"
						method="POST">
						<input type="submit" value="Logout" /> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form></li>
			</ul>
		</div>
	</nav>
	
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active" style="padding: 40px;">
				<img class="first-slide" src="img/ticket_booking.jpg"
					style="width: 100%; height: 600px;" alt="Book Your Ticket">

				<div class="container">
					<div class="carousel-caption">
						<h1 style="color: orange;">Book Your Ticket In One Go</h1>
						<p></p>
						<p>
							<a class="btn btn-lg btn-primary" href="addbooking" role="button">Book Your Ticket</a>
						</p>
					</div>
				</div>
			</div>

			<div class="item" style="padding: 40px;">
				<img class="second-slide" src="img/manage_user.jpg" style="width: 100%; height: 600px;"	

					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1 style="color: orange;">Manage Your Tickets</h1>
						<p></p>
						<p>
							<a class="btn btn-lg btn-primary" href="viewallbookings" role="button">Manage Your Tickets</a>
						</p>
					</div>
				</div>
			</div>

			<div class="item" style="padding: 40px;">
				<img class="third-slide" src="img/bus3.jpg" style="width: 100%; height: 600px;" alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>One stop for all your favorite buses.</h1>
						<p></p>
						<p>
							
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<jsp:include page="../linklib.jsp" />
	
	
</body>
</html>