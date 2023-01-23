package com.tweteroo.twetero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.twetero.dto.TweetDTO;
import com.tweteroo.twetero.model.TweetModel;
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
    public Page<TweetModel> list (@RequestParam("page")int page){
        Pageable paging = PageRequest.of(page, 5, Sort.by("id").descending());
        return (tweetService.listTweets(paging));
        
    }

    @GetMapping("/tweets/{username}")
    public List<TweetModel> getUserTweets(@PathVariable String username) {
        return tweetService.listUserTweets(username);
    }
    
}
