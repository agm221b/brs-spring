<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
	$(document).ready(function() {

		$('form[id="second_form"]').validate({
			rules : {
				fname : 'required',
				lname : 'required',
				user_email : {
					required : true,
					email : true,
				},
				psword : {
					required : true,
					minlength : 8,
				}
			},
			messages : {
				fname : 'This field is required',
				lname : 'This field is required',
				user_email : 'Enter a valid email',
				psword : {
					minlength : 'Password must be at least 8 characters long'
				}
			},
			submitHandler : function(form) {
				form.submit();
			}
		});

	});
	
	
</script>

<style type="text/css">
</style>

</head>
<body>


	<div class="container">
		<form id="login_form" class="col s6" action="logincheck" method="post">


			<div class="row">
				<div class="input-field col s6">
					<input id="username" placeholder="Username" type="text"
						name="username" required="required"> <label for="username">Username</label>
					<span style="color: red;"></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input id="password" placeholder="Password" type="password"
						name="password" required="required"> <label for="password">Password</label>
					<span style="color: red;"></span>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input type="submit" class="waves-effect waves-light btn"
						value="LOGIN"><br>
				</div>
			</div>
		</form>
		${errormessage }
	</div>

	<jsp:include page="linklib.jsp"></jsp:include>
	<jsp:include page="../webjar/jsp/footer.jsp"></jsp:include>
</body>
</html>