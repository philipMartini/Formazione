<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Processing GET requests In this JSP</title>
</head>
<body>

<%String name = request.getParameter("firstName");
	if(name != null){
%>
<h1>Hello <%=name%>
<br>
Welcome to JavaServerPages!
</h1>
<%} else{ %>

<form action="welcome.jsp" method="get">
<label>Type You Name And Press Submit!</label>
<input type="text" name="firstName"/>
<input type="submit" value="Submit!"/>
</form>

<%} %>

</body>
</html>