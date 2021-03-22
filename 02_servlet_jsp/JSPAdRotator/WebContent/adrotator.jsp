<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A JSP AdRotator</title>
<!-- Importo Il Bean -->
<jsp:useBean id="rotator" class="org.advancia.filippo.model.Rotator" scope="session"/>

<style type="text/css">
	.big {font-family: helvetica, arial, sans-serif;
			font-weight: bold;
			font-size: 2em;
	}
	
</style>
<!-- Aggiorna la pubblicità -->
<%rotator.nextAd(); %>

</head>
<body>

<p class="big">AdRotator Example</p>

<p>
<a href="<jsp:getProperty name="rotator" property="link"/>">
<img alt="advertismement" src="<jsp:getProperty name="rotator" property="image"/>" width="400" height="400">
</a>
</p>

</body>
</html>