<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A Simple JSP page That converts currencies</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Set"  %>


<body>

<%Set<String> currencies = (Set<String>) session.getAttribute("currencies"); %>



<form method="post" action="converter">
Convert From: 
<select name="fromCurrency" multiple size=3>
			
	<c:forEach items="${currencies}" var="item">
		<option value="${item}">${item}</option>
	</c:forEach>
			
</select>
Amount: <input name="amount"/>
Convert To:
<select name="toCurrency" multiple size=3>
	<c:forEach items="${currencies}" var="item">
		<option value="${item}">${item}</option>
	</c:forEach>
	</select>
	<input type="submit"/>
</form>
<br>
Converted Amount: <%= request.getAttribute("convertedAmount") %>
<br>
Number Of Requests fulFilled In this Session: <%=request.getSession().getAttribute("requestsNumb") %>

</body>
</html>