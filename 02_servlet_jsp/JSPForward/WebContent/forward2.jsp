<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.big{font-family: helvetica, arial, sans-serif;
		font-weight: bold;
		font-size: 2em;
	}
</style>
<title>The Jsp Page To Forward To</title>
</head>
<body>

<p class="big">Hello <%=request.getParameter("firstName") %></p>


<p class="big">You request Was Forwarded AT:</p>
<table style="background-color: black;">
	<tr>
		<td style="background-color: black;">
			<p class="big" style="color: cyan;"><%= request.getParameter("date") %></p>
		</td>
	</tr>
</table>

</body>
</html>