<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using jsp:include</title>

<style type ="text/css">
 body{ font-family: tahoma, helvetica, arial, sans-serif;
 }
 
 table, tr, td{
 
 	font-size: .9em;
 	border: 3px groove;
 	padding: 5px;
 	background-color: #dddddd;
 }
</style>
</head>
<body>

<table>

	<tr>
		<td style = "width: 160px; text-align="center">
			<img src="images/numpyLogo.png" width="140" height = "93">
		</td>
		
		<td> <jsp:include page="banner.html" flush="true"/></td>
	</tr>
	
	<tr> 
		<td style="width: 160px"> <jsp:include page="toc.html" flush="true"/></td>
		
		<td style="vertical-align: top">
			<jsp:include page="clock2.jsp" flush="true"/>
		</td>
	
	</tr>
</table>

</body>
</html>