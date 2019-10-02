<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

<style type="text/css">
.page-header {
	top: 0px;
	align-content: center;
	background-color: #ffe0b2;
	margin: 0px;
	margin-top: 0px;
	margin-bottom: 0px;
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

				<!-- lOGO TEXT HERE-->
				<!-- <a href="index.html" class="navbar-brand">Soft Landing</a> -->
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
			<div class="item active">
				<img class="first-slide" src="webjar/img/bus1.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Example headline.</h1>
						<p>
							Note: If you're viewing this page via a
							<code>file://</code>
							URL, the "next" and "previous" Glyphicon buttons on the left and
							right might not load/display properly due to web browser security
							rules.
						</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Sign
								up today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="webjar/img/bus2.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Another example headline.</h1>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								more</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="webjar/img/bus3.png"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>One more for good measure.</h1>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Browse
								gallery</a>
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



	<section id="home" 
		style="background-image: url(brs-spring/WebContent/webjar/img/bus-car.jpg); ">
		<!-- <div class="overlay"></div> -->
		<div class="container">
			<div class="page-header" align="center">
				<h3 style="font: bolder; font-family: cursive;">BusNama : Bas
					Explore Karo</h3>
			</div>
			<div class="row">

				<div class="col-md-offset-3 col-md-6 col-sm-12">
					<div class="home-info">
						<h3 align="center">
							<i>Welcome</i><br>
						</h3>
						<div class="container">
							<div class="row" align="left">
								<a href="login"> <input type="button"
									class="waves-effect waves-light btn" value="Login"></a><br>
							</div>
							<div class="row" align="left">
								<a href="register"> <input type="button"
									class="waves-effect waves-light btn" value="Register"></a><br>
							</div>
							<div class="row" align="left">
								<a href="help"> <input type="button"
									class="waves-effect waves-light btn" value="Help"></a><br>
							</div>
							<div class="row" align="left">
								<a href="aboutUs"> <input type="button"
									class="waves-effect waves-light btn" value="About Us"></a><br>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>


<jsp:include page="../webjar/jsp/footer.jsp"></jsp:include>


	
	

</body>
</html>