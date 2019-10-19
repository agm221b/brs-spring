<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

<style type="text/css">
.page-header {
	top: 0px;
	align-content: center;
	/* background-color: #ffe0b2; */
	margin: 0px;
	margin-top: 0px;
	margin-bottom: 0px;
}

#myCarousel{
	height: 700px;
	width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="linklib.jsp"></jsp:include>
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


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active" style="padding: 40px;">
				<img class="first-slide" src="img/bus1.jpg"
					style="width: 100%; height: 600px;" alt="First slide">

				<div class="container">
					<div class="carousel-caption">
						<h1 style="color: orange;">BusNama : Bas Explore Karo</h1>
						<p></p>
						<p>
							<a class="btn btn-lg btn-primary" href="login" role="button">Login</a>
						</p>
					</div>
				</div>
			</div>

			<div class="item" style="padding: 40px;">
				<img class="second-slide" src='<c:out value="img/bus2.jpg"/>' style="width: 100%; height: 600px;"	

					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<!-- <h1>Welcome</h1> -->
						<p></p>
						<p>
							<a class="btn btn-lg btn-primary" href="aboutUs" role="button">About Us</a>
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

	<!-- <section id="home"  background-size: 100%;">
		<div class="overlay"></div>
>>>>>>> branch 'master' of https://github.com/agm221b/brs-spring.git
		<div class="container">
			<div class="page-header" align="center">
				<h3 style="font: bolder; font-family: cursive;">BusNama : Bas
					Explore Karo</h3>
			</div>
			<div class="row">

				<div class="col-md-offset-3 col-md-6 col-sm-12">
					<div class="home-info">
						
						<div class="container">
							
						
						</div>
					</div>

				</div>
			</div>
		</div>
	</section> -->

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>