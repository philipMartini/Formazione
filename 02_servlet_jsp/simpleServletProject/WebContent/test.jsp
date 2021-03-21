<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Una JSP viene convertita in una servlet e per vedere il deploy basta andare nella dirctory
di Tomcat temporaneo /work-->

<h3>Testing JSPs</h3>

<%!
//Questo tag si usa per dichiarare metodi e lo scope è lintera pagina JSP

public int add(int i, int j) { return i + j; }
%>


<%
//Lo scope è ancora l'intera pagina.. Infatti
int i = 2;
int j = 7;
int k = add(i,j); 
//Al posto di usare una println 
//per stampare contenuti calcolati dinamicamente posso usare...
//out.println("Value of K is " + k);
%>
<!-- Questo tag -->
The value of K is: <%=k %>

<%for(;i < k; ++i) {%>
 <br> i = <%=i%>
<%} %>
</body>
</html>