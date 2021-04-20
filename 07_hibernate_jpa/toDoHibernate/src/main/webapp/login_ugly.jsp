<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDos WebApp Login</title>
</head>
<body>

<form method="post" action="todos">
	User Name: <input type="text" name="userName"/>
	<br>
	Password:<input type="password" name="password"/>
	<br>
	<input type="submit" name="login"/>
</form>
<% String error = (String) request.getAttribute("error");
	if(error != null){	%>
	<div><%=error%></div>
	<%} %>

</body>
</html>