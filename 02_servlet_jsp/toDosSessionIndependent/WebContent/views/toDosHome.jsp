<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.advancia.filippo.model.ToDo" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>To Dos Web App</title>
</head>
<body>
<% if (session.getAttribute("toDos") == null)
		session.setAttribute("toDos", new HashMap<String, ToDo>());%>
<h1>To Dos List</h1>
<h2><a href="http://localhost:8080/toDos/views/addToDo.jsp">Add a ToDo!</a></h2>
<ol>
<c:forEach items="${sessionScope.toDos.values()}" var="toDo" varStatus="loop">
		<li><a href="http://localhost:8080/toDos/toDos?id=${toDo.uuid}">${toDo.title}</a></li>
	</c:forEach>

</ol>



</body>
</html>