<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import="org.advancia.filippo.model.ToDo" %>
<%@ page import="org.advancia.filippo.model.User" %>
<%@ page import="java.util.*" %>

<html xmlns = "http://www.w3.org/1999/xhtml">
   <head>
      <title>Your ToDos</title>
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
   
    <%User user = (User) session.getAttribute("user"); %>
   
   <body>
      <p style = "font-size: 2em;"><%=user.getUserName() %>'s ToDos List</p>
      <table>
         <thead>
            <tr>
            	<th style = "width: 100px;">Index</th>
               <th style = "width: 100px;">ToDo Title</th>
               <th style = "width: 100px;">ToDo Text</th>
               <th style = "width: 200px;">Delete</th>
               <th style = "width: 200px;">Update</th>
            </tr>
         </thead>
         <tbody>
         <% // start scriptlet
         	Collection<ToDo> toDos =  (Collection<ToDo>)request.getAttribute("toDos"); 
            Iterator toDoListIterator = toDos.iterator();
            ToDo toDo;
           
            
            while ( toDoListIterator.hasNext() ) 
            {
               toDo = ( ToDo ) toDoListIterator.next();
         %> <%-- end scriptlet; insert fixed template data --%>
               <tr>
               	<form method = "post">
               		<td><input type = "text" name="toDoId" value="<%=toDo.getId() %>" readonly/></td>
                  <td><input type = "text" name = "toDoTitle" value="<%= toDo.getTitle() %>" /></td>
                  <td><input type = "text" name = "toDoText" value="<%= toDo.getText() %>" /></td>  
                  <td><input type = "submit"  name="delete" value = "Delete" /></td>
                  <td> <input type = "submit" name="update" value = "Update" /></td>
                 </form>
               </tr>
         <% // continue scriptlet
            } // end while
         %> <%-- end scriptlet --%>
         <!-- Riga per aggiunta nuovo caffe -->
         
         <tr>
            	<form method = "post">
            		<td> </td>
                  <td><input type = "text" name = "toDoTitle"/></td>
                  <td><input type = "text" name = "toDoText"/></td>
        
                  <td><input type = "submit" name="add" value = "Add" /></td>
                  <td> </td>
                  </form>
         </tr>
         
         </tbody>
      </table>
      
      <form method = "post">
            		
        
             <input type = "submit" name="logout" value = "LOGOUT" /></td>
                  
       </form>
      
   </body>
</html>