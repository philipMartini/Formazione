<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="org.advancia.filippo.dto.User" scope="request">
	<%--Posso importare una property per volta --%>
	<%-- <jsp:setProperty property="userName" name="user" param="userName"/>--%>
	<%--oppure importarle tutte con questo shortcut  in questo caso è possibile perche
	i request params matchano i nomi delle property--%>
	<jsp:setProperty property="*" name="user" />
</jsp:useBean>

Hello <jsp:getProperty property="userName" name="user"/>
Address 1: <jsp:getProperty property="address1" name="user"/>
Address2:<jsp:getProperty property="address2" name="user"/>
City:<jsp:getProperty property="city" name="user"/>
State:<jsp:getProperty property="state" name="user"/>
PinCode:<jsp:getProperty property="pincode" name="user"/>

</body>
</html>