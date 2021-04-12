<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Persona"%>
<%@ page import="model.Macchina"%>
<%@ page import="model.Corso "%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Persone</title>
<%
	List<Persona> listaPersone = (List<Persona>) session
			.getAttribute("listaPersone");
	List<Macchina> listaMacchine = (List<Macchina>) session
			.getAttribute("listaMacchine");
	List<Corso> listaCorsi = (List<Corso>) session
			.getAttribute("listaCorsi");
%>
</head>
<body>
	<h2>Contenuto della tabella Persone</h2>
	<table>
		<%
			for (int i = 0; i < listaPersone.size(); i++) {
				Persona p = listaPersone.get(i);
		%>
		<tr>
			<td><%=p.getNome()%></td>
			<td><%=p.getCognome()%></td>
			<td><%=p.getDataNascita()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<h2>Contenuto della tabella Macchine</h2>
	<table>
		<%
			for (int i = 0; i < listaMacchine.size(); i++) {
				Macchina m = listaMacchine.get(i);
		%>
		<tr>
			<td><%=m.getIdMacchina()%></td>
			<td><%=m.getModello()%></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<h2>Contenuto della tabella Corsi</h2>
	<table>
		<%
			for (int i = 0; i < listaCorsi.size(); i++) {
				Corso c = listaCorsi.get(i);
		%>
		<tr>
			<td><%=c.getIdCorso()%></td>
			<td><%=c.getDescrizione()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<h2>Relazione Uno a Molti (Persona - Macchina)</h2>
	<table>
		<%
			for (int i = 0; i < listaPersone.size(); i++) {
				Persona p = listaPersone.get(i);
		%>
		<tr>
			<td><%=p.getIdPersona()%></td>
			<td><%=p.getCognome()%></td>
			<td><%=p.getNome()%></td>
			<td><%=p.getDataNascita()%></td>

			<%
				for (Macchina m : p.getMacchine()) {
						
			%>
			<td><%=m.getIdMacchina()%></td>
			<td><%=m.getModello()%></td>
			<%
				}
				}
			%>
		</tr>
		</table>
	<h2>Relazione Molti a Uno (Macchina - Persona)</h2>
	<table>
		<%
			for (int i = 0; i < listaMacchine.size(); i++) {
				Macchina m = listaMacchine.get(i);
		%>
		<tr>
			<td><%=m.getIdMacchina()%></td>
			<td><%=m.getModello()%></td>
			<td><%=m.getPersona().getCognome()%>
			<td><%=m.getPersona().getNome()%>
		</tr>
		<%
			}
		%>
	</table>

	
		<h2>Relazione Molti a Molti (Persona - Corso)</h2>
	<table>
		<%
		for(Corso c: listaCorsi){
				
		%>
		<tr>
			<td><%=c.getIdCorso()%></td>
			<td><%=c.getDescrizione()%></td>
		
			<%
			for(Persona p: c.getPersone()){
						
			%>
			<td><%=p.getIdPersona()%></td>
			<td><%=p.getCognome()%></td>
			<td><%=p.getNome() %>
			<%
				}
				}
			%>
		</tr>
	</table>
</body>
</html>