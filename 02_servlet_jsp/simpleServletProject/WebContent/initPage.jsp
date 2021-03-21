<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Init params Example</title>
</head>
<%!

public void jspInit(){
	String defaultUser = getServletConfig().getInitParameter("defaultUser");
	ServletContext context = getServletContext();
	context.setAttribute("defaultUser", defaultUser);
}
%>

<body>

<!-- Importante ricordare che config è un dato membro della servlet e viene passato come parametro al metodo init() -->
The default User from the servlet config is: <%=getServletConfig().getInitParameter("defaultUser")%>
<!-- Diverso è il context che invece è uno scoped object applicabile per tutta l'applicazione (Quindi anche fra piu servlet)-->
The value in the Servlet context is: <%=getServletContext().getAttribute("defaultUser") %>



</body>
</html>