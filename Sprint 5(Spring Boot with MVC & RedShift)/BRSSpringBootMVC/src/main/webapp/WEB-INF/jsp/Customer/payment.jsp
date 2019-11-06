<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.col-sm-8{
height: 400px;
width: 600px;
background-color: white;
}
#container{
padding-left: 420px;

}
.row{
padding: 20px;
}
#submitbtn{
text-align: center;
}
h3{
text-align:center;
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
			<ul class="nav navbar-nav navbar-right">
			<li><a href="<%=request.getContextPath()%>/logout"><input type="button" value="Logout" class="btn btn-danger"><input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" /></a></li>
			</ul>
		</div>
	</nav>
	<br />
	<div class="row" id="container">
		<div class="col-sm-8">
		<h3>Payment Details:</h3>
			<form method="post" action="pdetail">
			<div class="row"><input type="radio" name="paymentMode" value="UPI">UPI</div>
			<div class="row"> <input type="radio" name="paymentMode" value="Debit Card">Debit Card</div>
			<div class="row"> <input type="radio" name="paymentMode" value="Credit Card">Credit Card </div>				
			<div class="row"><input type="radio" name="paymentMode" value="Net Banking">Net
				Banking</div>
				<div class="row" id="submitbtn"><input type="submit" value="Proceed" class="btn btn-info"></div>
 
			</form>
			</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>

</body>
</html>