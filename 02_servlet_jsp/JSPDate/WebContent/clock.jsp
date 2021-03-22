<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A Simple Clock Using JSP</title>
<meta http-equiv="refresh" content="60">
<style type="text/css">
	.big{font-family: helvetica, arial, sans-serif;
		font-weight: bold;
		font-size: 2em;
	}
</style>
</head>
<body>

<p class="big">Simple JSP example</p>
<table style="background-color: black;">
	<tr>
		<td style="background-color: black;">
			<p class="big" style="color: cyan;"><%= new java.util.Date() %></p>
		</td>
	</tr>
</table>
</body>
</html>