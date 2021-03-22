<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forward a Request to Another JSP</title>
</head>
<body>
<%String name = request.getParameter("firstName");
	if(name != null){
%>
<!-- Aggiungo un parametro alla richiesta prima di re indirizzare -->
<jsp:forward page="forward2.jsp">
	<jsp:param  name="date" value="<%= new java.util.Date() %>"/>
 </jsp:forward>
<%} else{ %>

<form action="forward1.jsp" method="get">
<label>Type You Name And Press Submit!</label>
<input type="text" name="firstName"/>
<input type="submit" value="Submit!"/>
</form>

<%} %>

</body>
</html>