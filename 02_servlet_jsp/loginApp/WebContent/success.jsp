<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<%@ page import="org.advancia.filippo.dto.User" %>

<body>
	<h3>Login Successful</h3>
	
<!-- Qui recuperiamo dalla session lo user object passato dall servlet -->


<!-- usando JSTL -->
<jsp:useBean id="user" class="org.advancia.filippo.dto.User" scope="request">
</jsp:useBean>
<!-- L'oggetto user viene definito automaticamente da JSTL tramite id= -->
Hello <%=user.getUserName()%>
Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>