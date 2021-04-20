<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ToDos WebApp</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital@1&display=swap" rel="stylesheet">
	
<style>
	* {
		box-sizing: border-box;
		padding: 0;
		margin: 0;
	}

	body {
		font-family: 'Raleway', sans-serif;
		background: #344a72;
		line-height: 1.8em;
	}

	a {
		text-decoration: none;
		color:#49c1a2;
	}

	.btn{
		width: 100%;
		padding: 7px;
		background: #49c1a2;
        color: white;
		cursor: pointer;
		font-size: 18px;
		margin-top: 15px;
		border-radius: 5%;
	}

	.btn:hover{
		 background: #37a08e;
	}

	.container {
		margin: 150px auto;
		max-width: 400px;
	}

	.container h1 {
		text-align: center;
		color: white;
		margin-bottom: 30px;
		font-size: 50px;
	}

	.form-wrap {
		background: white;
		padding: 30px 20px;

	}

	.form-wrap input{
		display: block;
		width: 100%;
		padding: 11px;
		margin: 10px 0;
		border-radius: 1%;
		border-color: #ddd;
	}

	.form-wrap input:focus{
		outline: none ;
    	border:1px solid red;
		border-color: #37a08e;
		box-shadow: 0 0 10px #719ECE;
	}

	.form-wrap label{
		margin-top: 20px;
		color: #333;
	}
	
	.error-message{
		color:red;
	}

	footer {
		padding: 10px;
		text-align: center;
		color: antiquewhite;
		font-size: 18px;
		background: #385486;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>ToDos WebApp</h1>
		<div class="form-wrap">
			<form method="post" action="todos">
				<label for="userName">User Name</label>
				<input type="text" name="userName"/>
				<label for="password">Password</label>
				<input type="password" name="password"/>
				<button class="btn" type="submit" name="login">Sign In</button>
				<% String error = (String) request.getAttribute("error");
					if(error != null){	%>
					<div class="error-message"><%=error%></div>
					<%} %>
			</form>

		</div> 
		<footer><p>Not registered ? <a href="signup.jsp">Sign Up Here</a></p></footer>

	</div>
	
	
	
</body>
</html>

