<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDos</title>
</head>

<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>


<body>

<%
Context ctx = new InitialContext();
DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/dbToDo");

Connection con = ds.getConnection();
out.println("Connection Established");

%>

</body>
</html>