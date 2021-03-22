<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Or Remove This ToDo</title>
</head>

<%@ page import="org.advancia.filippo.model.ToDo" %>

<body>

<jsp:useBean id="toDo" class="org.advancia.filippo.model.ToDo" scope="request">
</jsp:useBean>

<form method="post" action="/toDos/toDos?updateToDo=${param.id}">
<!-- Puoi estratrre con la getProperty -->
<div style="color: #FF0000;">${errorMessage}</div>
Title:<input name="title" value="<jsp:getProperty property="title" name="toDo"/>">
<!-- Oppure avendo settato i due campi nella request si può anche usare il requestScope -->
Text:<input name="text" value="${requestScope.text}">
<input type="submit" value="UPDATE">
</form>
<form method="post" action="/toDos/toDos?deleteToDo=${param.id}">
<input type="submit" value="DELETE">
</form>
</body>
</html>