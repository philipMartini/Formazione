<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a ToDo to Your List!</title>
</head>
<body>
<form method="post" action="/toDos/toDos?addToDo=create">
<div style="color: #FF0000;">${errorMessage}</div>
Title:<input name="title">
Text:<input name="text">
<input type="submit">
</form>

</form>


</body>
</html>