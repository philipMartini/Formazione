<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ToDos SignUp</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/main.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Raleway:ital@1&display=swap" rel="stylesheet">

        <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous"> -->
        <style>
            body{
                    font-family: Raleway, sans-serif;
            }
    </style>
    
    </head>
    <body class="bg-primary">
        
        <div class="container">
            <h1 class="display-1 text-center text-white my-5">ToDos WebApp</h1>
            <div class="form-wrap p-3 mb-5 bg-light">
                <h3 class="display-4 mb-3 text-center text-secondary">Sign Up</h1>
                <p class="lead text-center text-secondary">It's free for you to use!</p>
                <form method="post" action="${pageContext.request.contextPath}/todos">
                   
                    <div class="form-group">
                        <label for="userName">Username</label>
                        <input class="form-control" id="username" type="text" name="username" placeholder="Enter Username"/>
                        
                    </div>
                    
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input class="form-control" type="password" name="password" placeholder="Enter Password"/>
                    </div>
                    
                    <button class="btn btn-block mb-3 btn-info" type="submit" name="signup">Sign Up</button>
                    <div class="text-danger" id="error"><c:out value="${requestScope.error}" default=""/></div>
                </form>

                <footer><p class="lead text-center text-secondary">Already registered ? <a class="text-info nav-link d-inline pl-0"href="${pageContext.request.contextPath}/views/login.jsp">Sign In Here</a></p></footer>
            </div> 
            
    
        </div>
        
        
        <script src="${pageContext.request.contextPath}/views/mainLogin.js"></script>
    </body>
    </html>