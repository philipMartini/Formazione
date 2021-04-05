<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="org.advancia.filippo.model.Film"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista film</title>
</head>
<body>
<% 

List<Film> film = (List) request.getAttribute("film");
for(Film f: film ) {
	%>
	<p><%= f.getTitolo() %></p>
	<%
}
%>
</body>
</html>