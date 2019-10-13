<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Footer</title>
<style type="text/css">
#footer {
	position: absolute;
	height: auto;
	bottom: 0px;
	width: 100%;
	background-color: red;
	color: white;
	text-align: center;
}
</style>

</head>
<body>
	<jsp:include page="../../jsp/linklib.jsp"></jsp:include>

	<div class="fixed-bottom">
		<section id="footer">

			<footer class="page-footer">
				<div class="container">
					<div class="row">
						<div class="col l6 s12">
							<h5 class="white-text">BusNama</h5>
							<p class="grey-text text-lighten-4">One Stop Solution for all
								your Bus Travel Needs.</p>
						</div>
						<div class="col l4 offset-l2 s12">
							<h5 class="white-text">Links</h5>
							<ul>
								<li><a class="grey-text text-lighten-3" href="home">Home</a></li>
								<li><a class="grey-text text-lighten-3" href="help">Help</a></li>
								<li><a class="grey-text text-lighten-3" href="aboutUs">About
										Us</a></li>
								<li><a class="grey-text text-lighten-3" href="gallery">Gallery</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="footer-copyright">
					<div class="container">
						© 2019 Copyright BusNama Inc. <a
							class="grey-text text-lighten-4 right" href="#!">More Links</a>
					</div>
				</div>
			</footer>

		</section>
	</div>



</body>
</html>