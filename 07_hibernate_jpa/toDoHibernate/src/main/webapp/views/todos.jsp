<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.advancia.filippo.model.ToDo" %>
<%@ page import="org.advancia.filippo.model.User" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/style.css">
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital@1&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/9a3935e417.js" crossorigin="anonymous"></script>
    <title>ToDos WebApp</title>
</head>

<!--<%User user = (User) session.getAttribute("user"); %>-->

<body>

     <!--Header-->
     <header class="bg-dark">
         <div>
            <h1 class="l-heading"><i class="fas fa-clipboard-list"></i></i><span class="text-primary"> <%=user.getUserName() %></span>'s Todos</h1>
        </div>
        <div>
            <form action="" method="post">
                <button class="btn btn-primary m-heading" type="submit" name="logout">Logout</button>
            </form>
        </div>
    </header>
<div class="container">

    <!--Main section-->
    <main>
        <div class="container bg-light p-2" id="todos-container">


            <div class="todo-group" id="filter-todo">
                	<h4 class="m-heading">Filter ToDos</h4>
                    <div class="todo-main-view">
                        <div>
            
                            <button type="button" class="control-btn"  id="plus-btn"><i class="fas fa-plus-circle fa-2x"></i></button>
                            <input class="m-heading" type = "text" name = "todo-filter" id="todo-filter" placeholder="Filter by Title"/>
                        </div>
                    </div>     
            </div>
        
       <% // start scriptlet
         	List<ToDo> toDos = (List<ToDo>) request.getAttribute("toDos"); 
            Iterator toDoListIterator = toDos.iterator();
            ToDo toDo;
           
            
            while ( toDoListIterator.hasNext() ) 
            {
               toDo = ( ToDo ) toDoListIterator.next();
         %>

            <!--View toDo !-->
            <div class="todo-group" id="todo-group-<%=toDo.getId()%>">
                    <form method = "post" action="todos">
                    
                        <div class="todo-main-view" id="todo-main-view-<%=toDo.getId()%>">
                            <div>
                                <button class="control-btn" id="done-btn-<%=toDo.getId()%>"type="submit" name="done"><i class="far fa-check-circle fa-2x"></i></button>
                                <input class="to-hide" type = "text" name="toDoDone" value="<%=toDo.isDone()%>"/>
                                <input class="m-heading" id="todo-title-<%=toDo.getId()%>" type = "text" name = "toDoTitle" value="<%= toDo.getTitle() %>" />
                                <input class="to-hide" type = "text" name="toDoId" value="<%=toDo.getId()%>" readonly/>
                            </div>

                            <div>
                                <button class="control-btn"  id="show-todo-text-<%=toDo.getId()%>" type="button"><i class="fas fa-caret-left fa-2x"></i></button>
                            </div>
                        </div>

                        <div class="todo-text-view" id="todo-text-view-<%=toDo.getId()%>">
                            <div class="item">
                                <input  class="lead" id="todo-text-<%=toDo.getId()%>" type = "text" name = "toDoText" value="<%= toDo.getText() %>" />
                            </div>
                            <div class="controls item">
                                <div>
                                    <input class="control-btn text-primary" type = "submit"  name="delete" value = "Delete" />
                                </div>
                                <div>
                                    <input class="control-btn text-primary" type = "submit" name="update" value = "Update" />
                                </div>
                            </div>
                        </div>
                    
                    </form>
                    
            </div>



            
			<%} %>
            

            
            <!--Add toDO-->
            
            <div class="todo-group" id="add-todo-view">
                <form method = "post" action="todos">
                    <div class="todo-main-view">
                        <div>
                            <button type="button" class="control-btn"  id="plus-btn"><i class="fas fa-plus-circle fa-2x"></i></button>
                            <input class="m-heading" type = "text" name = "toDoTitle" placeholder="Enter a Title"/>
                        </div>
                    </div>
                    <div class="todo-text-view" id="todo-add-text-view">
                        <div>
                            <input  class="lead" type = "text" name = "toDoText" placeholder="Enter The Text" />
                        </div>
                        <div class="controls">
                            <div>
                                <input class="control-btn text-primary" type = "submit"  name="add" value = "Add" />
                            </div>
                        </div>
                    </div>
                
                </form>
        </div>
           

        </div>
    </main>

</div>

    <script src="${pageContext.request.contextPath}/views/app.js"></script>
</body>
</html>