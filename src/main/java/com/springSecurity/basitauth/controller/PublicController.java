package com.springSecurity.basitauth.controller;

import com.springSecurity.basitauth.model.User;
import com.springSecurity.basitauth.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {



    @GetMapping
    public String helloWorldPublic(){
        return "Hello world from Public Controller";
    }



}
