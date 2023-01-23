package com.tweteroo.twetero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.twetero.dto.UserDTO;
import com.tweteroo.twetero.model.UserModel;
import com.tweteroo.twetero.service.UserService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class User {

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/sign-up")
    public String createUser(@RequestBody @Valid UserDTO req){
       return userService.createUser(req);
        
    }

    @GetMapping
    public List<UserModel> userList(){
        return userService.userList();
    }
}
