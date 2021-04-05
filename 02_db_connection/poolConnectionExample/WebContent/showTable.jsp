<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page import = "org.advancia.filippo.model.Person" %>
<%@ page import = "java.util.List" %>
<% String action = (String) request.getAttribute("action"); %>
<% List<Person> people = (List<Person>) request.getAttribute("people"); %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>People</title>
</head>
<body>

	<%
		if (action.equals("select") || action.equals("delete") || action.equals("editRequest")){
			for (Person p : people) {
	%>
	
				<table>
					<tr>
						<td>ID: <%= p.getId() %></td>
						<td>FirstName: <%= p.getFirstName() %></td>
						<td>LastName: <%= p.getLastName() %></td>
						<td>Age: <%= p.getAge() %></td>
					</tr>
				</table>
	
	<%
			}
		}
	%>
	<% if (action.equals("delete")) { %>
	
	<form action = "/poolConnectionExample/CRUDServlet" method = "get">
		<p>Type the id of the person to delete:</p>
		<input type = "text" name = "id" />
		<input type = "submit" name = "op" value = "Delete" />
	</form>
	<% } %>
	
	<% if (action.equals("editRequest")) { %>
	<form action = "/poolConnectionExample/CRUDServlet" method = "get">
		<p>Type the id of the person to edit:</p>
		<input type = "text" name = "id" />
		<input type = "submit" name = "op" value = "edit" />
	</form>
	<% } %>
	<p>Thank you! Click the button below to go back to the Hompage.</p>
	<form action = "/poolConnectionExample/CRUDServlet" method = "get">
		<input type = "submit" name = "op" value = "Home" />
	</form>
</body>
</html>