<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="org.advancia.filippo.model.Person" %>
<% String action = (String) request.getAttribute("action"); %>
<% Person p = (Person) request.getAttribute("person"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit</title>
</head>
<body>
	<form action = "/poolConnectionExample/CRUDServlet" method = "get">
		<input type = "hidden" name = "id" value = "<%= p.getId() %>" />
		First Name: 
		<input type = "text" name = "firstName" value = "<%= p.getFirstName() %>" /><br/> 
		Last Name:
		<input type = "text" name = "lastName" value = "<%= p.getLastName() %>" /><br/>
	 	Age: 
	 	<input type = "text" name = "age" value = "<%= p.getAge() %>" /><br/>
	 	<% if (action.equals("Change")) { %>
			<input type = "submit" name = "op" value = "Change" />
		<% } %>
		<% if (action.equals("Add")) { %>
			<input type = "submit" name = "op" value = "Add" />
		<% } %>
	</form>
</body>
</html>