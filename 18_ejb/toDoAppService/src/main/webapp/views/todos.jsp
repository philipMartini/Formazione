 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.advancia.filippo.model.ToDo" %>
<%@ page import="org.advancia.filippo.model.User" %>
<%@ page import="java.util.*" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/style.css"> -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/main.css">

    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous"> -->
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital@1&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/9a3935e417.js" crossorigin="anonymous"></script>
    <title>ToDos WebApp</title>
</head>

<!--<%/*User user = (User) session.getAttribute("user");*/ %>-->

<body class="bg-primary">

     <!--Header-->

    <nav class="navbar navbar-expand-sm sticky-top bg-secondary text-white mb-3">
        <div class="container">
            <h1 class="navbar-brand"><i class="fas fa-clipboard-list"></i></i><span class="text-info display 2"> ${sessionScope.user.getUserName()}</span>'s Todos</h1>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <form action="" method="post">
                        <button class="btn btn-info" type="submit" name="logout">Logout</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>



    <div class="container bg-light py-3">

         <!--Filter ToDos-->
        <div class="input-group mb-3">      
            <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-search"></i></span> 
            </div>
            <input class="form-control" type = "text" name = "todo-filter" id="todo-filter" placeholder="Filter by Title"/>
        </div>
        
     
		
            <!--View toDo !-->
            
        

        <ul class="list-group" id="toDosList">
			<c:forEach items="${requestScope.todos}" var="toDo" varStatus="counter">
            
            <li class="list-group-item" id="${toDo.getId()}>">
                <div class="card mb-3" id="todo-group-${toDo.getId()}">
                        <form method = "post" action="todos" id="todo-form-${toDo.getId()}">
                        
                            <div class="card-header d-flex  justify-content-between" id="todo-main-view-${toDo.getId()}">
                                
                                    <button class="btn" id="done-btn-${toDo.getId()}" type="button" name="done" value="${toDo.isDone()}">
                                        <i class="far fa-check-circle fa-2x"></i>
                                    </button>
                                    
                                    <!-- <input class="invisible" type = "text" name="toDoDone" value="${toDo.isDone()}"/> -->
                                    
                                   <!--  <h3 class="card-title mt-1"> -->
                                        <input class="form-control" id="todo-title-${toDo.getId()}" type = "text" name = "toDoTitle" value="${toDo.getTitle()}" />
                                   <!--  </h3> -->
                                  <input type = "hidden" name="toDoId" value="${toDo.getId()}" readonly/>
                                    <button class="btn"  id="show-todo-text-${toDo.getId()}" type="button" data-toggle="collapse" data-target="#todo-text-view-${toDo.getId()}"><i class="fas fa-caret-left fa-2x"></i></button>
                            </div>
                            <div class="collapse" id="todo-text-view-${toDo.getId()}">
                                <div  class="card-body d-flex flex-wrap justify-content-between">
                                
                                    <p class="card-text lead">
                                        <input  class="form-control" id="todo-text-${toDo.getId()}" type = "text" name = "toDoText" value="${toDo.getText()}" />
                                    </p>
                                
                                    <div>
                                        
                                        <input class="btn text-info" id="delete-btn-${toDo.getId()}"type = "button"  name="delete" value = "Delete" />
                                        <input class="btn text-info" id="update-btn-${toDo.getId()}" type = "submit" name="update" value = "Update" />
                                        <input id="form-param-${toDo.getId()}" type="hidden"  name="">
                                        
                                    </div>
                                </div>

                            </div>
                            
                        
                        </form>
                        
                </div>
            </li>

            
			</c:forEach>
        </ul>

      
        <!--Add toDO-->
        <form method = "POST" action="todos" id="add-todo-form"> 
            <div class="input-group">
            
                <div class="input-group-prepend">
                    <button type="button" class="btn input-group-text"  id="plus-btn">
                        <i class="fas fa-plus-circle"></i>
                    </button>
                </div>
                    
                    <input class="form-control" type = "text" name = "toDoTitle" id="add-todo-title" placeholder="Enter a Title"/>
                    <input  class="form-control" type = "text" name = "toDoText" placeholder="Enter The Text" />
                	<input type="hidden" name = "add" value="add">
                
                    <div class="input-group-append">
                        <button class="btn  btn-outline-dark text-info" type = "button" id="add-todo-btn" >Add</button>
                    </div>
                    <div class="invalid-feedback"></div>
            </div>
        </form>

    </div>

    <!-- <script src="${pageContext.request.contextPath}/views/app.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

    <script src="${pageContext.request.contextPath}/views/ui.js"></script>
    <script src="${pageContext.request.contextPath}/views/main.js"></script>
</body>
</html>