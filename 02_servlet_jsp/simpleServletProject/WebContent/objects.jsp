<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scopes And Page Context</title>
</head>
<body>
<%
//Trovandoci nel metodo service, possiamo tranquillamente accedere a l'oggetto request
String userName = request.getParameter("name");

if(userName != null){
	//Per accedere alla sessione
	session.setAttribute("sessionUserName", userName);
	//Uguale per il context, ma qui è nominato application
	application.setAttribute("contextUserName", userName);
	//Nelle JSP esiste anche il page context
	pageContext.setAttribute("pageContextUserName", userName);
	//Usando il page context posso settare un attibuto dell'application/session/request context
	//pageContext.setAttribute("applicationUserName", userName, PageContext.APPLICATION_SCOPE);
	//Uno dei vantaggi di settare con il page context è la possibilità di usare il metodo find
	//Quando non sappiamo in quale scope sia un attributo
	pageContext.findAttribute("name");
}

%>

The Request user Name is: <%=request.getParameter("name")%>
<br>
The Session user Name is: <%=session.getAttribute("sessionUserName")%>
<br>
The Application Context user Name is: <%=application.getAttribute("contextUserName")%>
<br>
The Page Context useName is: <%=pageContext.getAttribute("pageContextUserName") %>
</body>
</html>