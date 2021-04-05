<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*, java.util.ArrayList, org.advancia.filippo.model.*" %>
<%
	ArrayList<Elemento> tab = (ArrayList<Elemento>)request.getAttribute("pers");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati</title>
</head>
<body>
	Elenco dei risultati
	<br/>
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Età</td>
		</tr>
		<%
			for(Elemento el : tab)
			{
		%>
		<tr>
			<td><%= el.getNome() %></td>
			<td><%= el.getCognome() %></td>
			<td><%= el.getEta() %></td>
		</tr>
		<%
			}
		%>			
	</table>
</body>
</html>