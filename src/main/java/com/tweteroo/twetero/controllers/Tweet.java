package com.tweteroo.twetero.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.twetero.dto.TweetDTO;
import com.tweteroo.twetero.service.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class Tweet {
    @Autowired
    private TweetService tweetService;

    @PostMapping("/tweets")
    public ResponseEntity<String> newTweet(@RequestBody TweetDTO req,@RequestHeader("User") String username){
        tweetService.newTweet(req,username);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
    
    
    @GetMapping("/tweets")
    public List listTweets(@RequestParam String page){
        return tweetService.listTweets();
        
    }
}
