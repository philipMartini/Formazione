<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

<form method="post" action="process.jsp">
	User ID: <input type="text" name="userId"/>
	<br>
	User Name:<input type="text" name="userName"/>
	<br>
	Address1 :<input type="text" name="address1"/>
	<br>
	Address2 :<input type="text" name="address2"/>
	<br>
	City :<input type="text" name="city"/>
	<br>
	State :<input type="text" name="state"/>
	<br>
	PinCode :<input type="text" name="pincode"/>
	<br>
	<input type="submit"/>
</form>

</body>
</html>