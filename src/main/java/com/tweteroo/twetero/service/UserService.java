package com.tweteroo.twetero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tweteroo.twetero.dto.UserDTO;
import com.tweteroo.twetero.model.UserModel;
import com.tweteroo.twetero.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public String createUser(UserDTO userData){
        if(existUsername(userData.username())){
            userRepository.save(new UserModel(userData) );
            throw new ResponseStatusException(HttpStatus.ACCEPTED,"OK");
        } 
        throw new ResponseStatusException(HttpStatus.CONFLICT);   
    }
    
    public List<UserModel> userList(){
        return userRepository.findAll();
    }

    private List<UserModel> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    private boolean existUsername(String username){
        return findByUsername(username).isEmpty(); 
    }
}
