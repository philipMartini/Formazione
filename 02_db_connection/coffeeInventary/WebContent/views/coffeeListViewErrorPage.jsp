<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- Fig. 27.24: guestBookErrorPage.jsp -->

<%-- page settings --%>
<%@ page isErrorPage = "true" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>Error!</title>
      <style type = "text/css">
         .bigRed 
		 {
            font-size: 2em;
            color: red; 
            font-weight: bold;
         }
      </style>
   </head>
   <body>
      <p class = "bigRed"> 
      <% // scriptlet to determine exception type
         // and output beginning of error message
         if ( exception instanceof SQLException )
         {
      %>

            A SQLException

      <%
         } // end if
		 else if ( exception instanceof ClassNotFoundException )
         {
      %>

            A ClassNotFoundException

      <%
         } // end else if
         else
         {
      %>

            An exception

      <%
         } // end else
      %>
      <%-- end scriptlet to insert fixed template data --%>

         <%-- continue error message output --%>
         occurred while interacting with the dbCaffe database. 
      </p>
      <p class = "bigRed">
         The error message was:<br />
         <%= exception.getMessage() %>
      </p>
      <p class = "bigRed">Please try again later</p>
   </body>
</html>

