<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Persona"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista Persone</title>
	<%
	List<Persona> listaPersone =(List<Persona>)(Object)session.getAttribute("listaPersone");
	%>
</head>
<body>
	<h2>Contenuto della tabella Persone</h2>
	<table>
<%
for(int i=0; i< listaPersone.size();i++){
	Persona p= listaPersone.get(i);
%>
			<tr>
				<td><%= p.getNome() %></td>
				<td><%= p.getCognome() %></td>
				<td><%= p.getData_nascita() %></td>
			</tr>
<%
		}
%>
	</table>

</body>
</html>