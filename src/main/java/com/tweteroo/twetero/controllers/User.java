package com.tweteroo.twetero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.twetero.dto.UserDTO;
import com.tweteroo.twetero.model.UserModel;
import com.tweteroo.twetero.repository.UserRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/user")
public class User {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/sign-up")
    public String createUser(@RequestBody @Valid UserDTO req){
        userRepository.save(new UserModel(req));
        return "OK";
    }

    @GetMapping
    public List<UserModel> userList(){
        return userRepository.findAll();
    }
}
