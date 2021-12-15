<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Init params Example</title>
</head>
<%!
//Overriding del metodo init() della jsp, viene chiamato alla prima richiesta ricevuta dalla JSP.
public void jspInit(){
	String defaultUser = getServletConfig().getInitParameter("defaultUser");
	ServletContext context = getServletContext();
	context.setAttribute("defaultUser", defaultUser);
}
%>

<body>

<!-- Importante ricordare che config è un dato membro della servlet e viene passato come parametro al metodo init() -->
<h3>The default User from the servlet config is: <%=getServletConfig().getInitParameter("defaultUser")%></h3>
<!-- Diverso è il context che invece è uno scoped object applicabile per tutta l'applicazione (Quindi anche fra piu servlet)-->
<h3>The value in the Servlet context is: <%=getServletContext().getAttribute("defaultUser") %></h3>



</body>
</html>