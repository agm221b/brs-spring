<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/customer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
#main{
color: black;
height: 500px;
}
.col-sm-4{
width:800px;
height:400px;
padding:10px;
background-color: white;
color:white;
text-align:center
}

img{
height:300px;
width:300px;
padding-top:20px;
padding-bottom: 10px;
}
</style>
</head>
<body style="background-color: #fff9c4;">
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
			</ul>
			<ul class="nav navbar-nav right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout" class="btn btn-danger"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
<marquee><h2><i>Welcome to BusNama </i><br></h2></marquee>
<div class="container" id="main">
<div class="row">
<div class="col-sm-4"><img src="img/addbus.jpg"><a class="waves-effect waves-light btn" href="addbus">Add Bus</a><br></div>
<div class="col-sm-4"><img src="img/showallbuses.jpg"><a class="waves-effect waves-light btn" href="showbuses">Show All Buses</a><br></div>
<div class="col-sm-4"><img src="img/showallusers.jpg"><a class="waves-effect waves-light btn" href="showusers">Show All Users</a><br></div>
</div>
</div>


<jsp:include page="../linklib.jsp"></jsp:include>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>