<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
<style type="text/css">


section.center{
align-items: center;
padding: 1%;
padding-left: 20%;
padding-right: 20%;

} 


</style>

</head>
<body style="background-color: #fff8e1;" >

<section class="navbar custom-navbar navbar-fixed-top"
		role="navigation">
		<div class="container">

			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon icon-bar"></span> <span class="icon icon-bar"></span>
					<span class="icon icon-bar"></span>
				</button>

				
			</div>

			<!-- MENU LINKS -->
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home" class="smoothScroll">Home</a></li>
					<li><a href="aboutUs" class="smoothScroll">About us</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login" class="smoothScroll">Login</a></li>
					<li><a href="register" class="smoothScroll">Register</a></li>
				</ul>

			</div>

		</div>
	</section>

	<section class="center">
	<h4>What is BusNama?</h4>
	
	  <p class="card-panel hoverable" id="card" > We are a small group started in 2019 with the purpose to cater
		all your basic to advanced bus travel needs 24x7, 365 days a year.
		With a technical group of developers ,we try our level best to make
		this a smooth and happy experience for all our customers. Thank you
		for visiting BusNama, we are here to help.
		<br>
		-Team BusNama</p>
	
	</section>
	<jsp:include page="linklib.jsp"></jsp:include>
	<jsp:include page="../webjar/jsp/footer.jsp"></jsp:include>
</body>
</html>