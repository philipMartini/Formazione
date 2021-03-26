<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Index</title>
</head>
<body>
	<p><h1>Available Database Operations</h1></p>
 	<form action = "/poolConnectionExample/CRUDServlet" method = "get">

    	<p>Which operation would you like to perform?</p>
		<p>
			<input type="radio" name = "op"
				value = "select" checked="checked" />SELECT<br />
			<input type="radio" name = "op"
				value = "add" />INSERT<br />
			<input type="radio" name = "op"
				value = "editRequest" />UPDATE<br />
			<input type="radio" name = "op"
				value = "delete" />DELETE
		</p>
		<p><input type="submit" value="Submit" /></p>
   </form>

</body>
</html>