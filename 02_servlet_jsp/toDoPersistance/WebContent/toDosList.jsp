<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- Fig. 27.23: guestBookView.jsp -->

<%-- page settings --%>
<%@ page import = "java.util.*" %>
<%@ page import = "org.advancia.filippo.model.*" %>


<%if (session.getAttribute("toDos") == null){ out.println("IS NULL!");%>
	<jsp:forward page="toDos" />
	
	<%} %>
	

     

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>To Dos</title>
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
      <p style = "font-size: 2em;">TODOs</p>
      <table>
         <thead>
            <tr>
            	<th style = "width: 100px;">Id</th>
               <th style = "width: 100px;">Title</th>
               <th style = "width: 100px;">Text</th>

               <th style = "width: 200px;">Delete</th>
               <th style = "width: 200px;">Update</th>
            </tr>
         </thead>
         <tbody>
         <% // start scriptlet
            List toDosList = (List) session.getAttribute("toDos");
            Iterator toDosListIterator = toDosList.iterator();
            ToDoBean toDo;
            

            while ( toDosListIterator.hasNext() ) 
            {
               toDo = ( ToDoBean ) toDosListIterator.next();
         %> <%-- end scriptlet; insert fixed template data --%>
               <tr>
               	<form method = "post"  action="toDos">
               		<td><input type = "text" name="id" value="<%= toDo.getId()%>" readonly/></td>
                  <td><input type = "text" name = "title" value="<%= toDo.getTitle() %>" /></td>
                  <td><input type = "text" name = "text" value="<%= toDo.getText() %>" /> </td>
                  <td><input type = "submit"  name="delete" value = "Delete" /></td>
                  <td> <input type = "submit" name="update" value = "Update" /></td>
                 </form>
               </tr>
         <% // continue scriptlet
            } // end while
         %> <%-- end scriptlet --%>
         <!-- Riga per aggiunta nuovo toDo -->
         
         <tr>
            	<form method = "post" action="toDos">
            		<td> </td>
                  <td><input type = "text" name = "title"/></td>
                  <td><input type = "text" name = "text"/></td>
                
                  
                  <td><input type = "submit" name="add" value = "Add" /></td>
   
                  </form>
               </tr>
         
         </tbody>
      </table>
   </body>
</html>

