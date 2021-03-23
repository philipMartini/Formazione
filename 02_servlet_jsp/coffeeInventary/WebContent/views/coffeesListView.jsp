<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- Fig. 27.23: guestBookView.jsp -->

<%-- page settings --%>
<%@ page errorPage = "guestBookErrorPage.jsp" %>
<%@ page import = "java.util.*" %>
<%@ page import = "org.advancia.filippo.model.*" %>

<%-- GuestDataBean to obtain guest list --%>
<jsp:useBean id = "coffeeData" scope = "request" 
   class = "org.advancia.filippo.model.CoffeeDataBean" />

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>Coffee List</title>
      <style type = "text/css">
         body 
		 { 
            font-family: tahoma, helvetica, arial, sans-serif; 
         }
         table, tr, td, th 
         { 
            text-align: center;
            font-size: .9em;
            border: 3px groove;
            padding: 5px;
            background-color: #dddddd;
         }
      </style>
   </head>
   <body>
      <p style = "font-size: 2em;">Coffees List</p>
      <table>
         <thead>
            <tr>
               <th style = "width: 100px;">Coffee name</th>
               <th style = "width: 100px;">Coffee price</th>
               <th style = "width: 200px;">Coffee quantity</th>
               <th style = "width: 200px;">Delete</th>
               <th style = "width: 200px;">Update</th>
            </tr>
         </thead>
         <tbody>
         <% // start scriptlet
            List coffeesList = coffeeData.getCoffeesList();
            Iterator coffeesListIterator = coffeesList.iterator();
            CoffeeBean coffee;

            while ( coffeesListIterator.hasNext() ) 
            {
               coffee = ( CoffeeBean ) coffeesListIterator.next();
         %> <%-- end scriptlet; insert fixed template data --%>
               <tr>
               		<form method = "post" action = "coffees?action=delete">
                  <td><input type = "text" name = "coffeeName" value="<%= coffee.getCoffeeName() %>" /></td>
                  <td><input type = "text" name = "coffeePrice" value="<%= coffee.getPrice() %>" /></td>
                  <td><input type = "text" name = "coffeeQuantity" value="<%= coffee.getQuantity() %>"/> </td>
                  <td><input type = "submit" value = "Delete" /></td>
                  <td> <input type = "submit" value = "Update" /></td>
                  </form>
               </tr>
         <% // continue scriptlet
            } // end while
         %> <%-- end scriptlet --%>
         </tbody>
      </table>
   </body>
</html>

