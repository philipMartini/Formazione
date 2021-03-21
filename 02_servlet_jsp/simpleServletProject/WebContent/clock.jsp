<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Page to See The Time!</title>
</head>
<body>

<!-- Supponendo di aver scritto funzioni utili nella pagina hello.jsp -->
<%@ include file="/hello.jsp" %>
<h1>The Time IS:</h1> <%=new Date() %>

</body>
</html>