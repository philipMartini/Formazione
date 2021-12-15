package io.javabrains.springbootsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }
    
    //Accessible for admin and user roles
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }
    
    //Accessible by only admin
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
