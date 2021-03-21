<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.advancia.filippo.model.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>


<body>

<h1>This is The List of Currently Registered Users</h1>

<ol>
	<c:forEach items="${usersList}" var="user" varStatus="loop">
		<li><a href="http://localhost:8080/registeredUsers/usersLista?id=${loop.index}">${user.email}</a></li>
	</c:forEach>
</ol>
<a href="http://localhost:8080/registeredUsers/views/userForm.jsp">Add Yourself To The List!</a>
</body>
</html>