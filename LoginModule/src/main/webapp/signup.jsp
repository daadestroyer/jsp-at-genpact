<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	%>
	<div class="container mt-5 jumbotron">
		<h1>Signup Form</h1>




		<form action="registerServlet" method="get" class="mt-5">
			<div class="form-group">
				<label>Username</label> <input type="text" name="uname"
					class="form-control" placeholder="Enter username">

			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" name="upass"
					class="form-control" placeholder="Password">
			</div>
			
			<a href="login.jsp">Login Here</a>

			<button type="submit" class="mt-4 btn btn-outline-primary btn-block">Submit</button>
			 
			<button type="reset" class="btn btn-outline-danger btn-block">Reset</button>
		</form>

		<%
		if (message != null) {
		%>
		<div class="mt-3">
			<span class="mt-3" style="color: red;'"><%=message%> </span>
		</div>
		<%
		}
		%>


	</div>




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>