<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous"> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/main.css">

	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital@1&display=swap" rel="stylesheet">

	<style>
		body{
				font-family: Raleway, sans-serif;
		}
</style>
	<title>ToDos WebApp</title>
</head>
<body class="bg-primary">

	<div class="container">
		<h1 class="text-center display-1 text-white my-5">ToDos WebApp</h1>
		<div class="card p-3 bg-light">
			<form method="post" action="${pageContext.request.contextPath}/todos" id="login-form">
				<div class="form-group">
					<label class="lead" for="username">Username</label>
					<input class="form-control" type="text" name="username"
					placeholder="Enter Username" id="username"/>
				</div>

				<div class="form-group mb-4">
					<label class="lead" for="password">Password</label>
					<input class="form-control"type="password" name="password" placeholder="Enter Password"/>
					

				</div>
				
				<button class="btn btn-block btn-info mb-3" id="login-submit-btn" type="submit" name="login">Sign In</button>
		
				<div class="text-danger" id="error"><c:out value="${requestScope.error}" default=""/></div>
						
			</form>

			<div id="not-registered">
				<p class="lead text-center text-secondary">Not registered ? <a class="text-info nav-link d-inline px-0" href="${pageContext.request.contextPath}/views/signup.jsp">Sign Up Here</a>
			</p>
		</div>		
	</div>
	
	<script src="${pageContext.request.contextPath}/views/ui.js"></script>
	<script src="${pageContext.request.contextPath}/views/mainLogin.js"></script>
	
</body>
</html>

