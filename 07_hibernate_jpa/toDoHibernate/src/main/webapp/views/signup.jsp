<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ToDos SignUp</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/style.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Raleway:ital@1&display=swap" rel="stylesheet">
        
    
    </head>
    <body>
        <div class="container">
            <h1 class="l-heading text-center">ToDos WebApp</h1>
            <div class="form-wrap bg-light">
                <h1 class="m-heading text-center">Sign Up</h1>
                <p class="text-center">It's free for you to use!</p>
                <form method="post" action="${pageContext.request.contextPath}/todos">
                    <label for="userName">User Name</label>
                    <input type="text" name="userName"/>
                    <label for="password">Password</label>
                    <input type="password" name="password"/>
                    <button class="btn" type="submit" name="signup">Sign Up</button>
                    <% String error = (String) request.getAttribute("error");
                        if(error != null){	%>
                        <div class="error-message"><%=error%></div>
                        <%} %>
                </form>

                <footer><p class="bottom-text text-center">Already registered ? <a href="${pageContext.request.contextPath}/views/login.jsp">Sign In Here</a></p></footer>
            </div> 
            
    
        </div>
        
        
        
    </body>
    </html>