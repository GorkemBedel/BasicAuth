package com.springSecurity.basitauth.controller;

import com.springSecurity.basitauth.model.User;
import com.springSecurity.basitauth.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/private")
public class PrivateController {

    private UserService userService;

    PrivateController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String helloWorldPrivate(){
        return "Hello world from Private Controller";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String helloWorldUser(){
        return "Private User controller";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String helloWorldAdmin(){
        return "Private admin controller.";
    }

    @GetMapping("/getUsers")
    @PreAuthorize("hasAnyRole('ADMIN','MOD')")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}
