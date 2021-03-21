<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserProfile</title>
</head>
<body>

<jsp:useBean id="user" class="org.advancia.filippo.model.User" scope="request">
</jsp:useBean>
<!-- L'oggetto user viene definito automaticamente da JSTL tramite id= -->
User Name: <jsp:getProperty property="firstName" name="user"/>
<br>
User Surname: <jsp:getProperty property="lastName" name="user"/>
<br>
User Email: <jsp:getProperty property="email" name="user"/>

</body>
</html>