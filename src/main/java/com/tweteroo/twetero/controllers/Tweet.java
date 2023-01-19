package com.tweteroo.twetero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.twetero.dto.TweetDTO;
import com.tweteroo.twetero.model.TweetModel;
import com.tweteroo.twetero.repository.TweetRepository;

@RestController
@RequestMapping("/api")
public class Tweet {
    @Autowired
    private TweetRepository tweetRepository;

    @PostMapping("/tweets")
    public String newTweet(@RequestBody TweetDTO req){
        tweetRepository.save(new TweetModel(req));
        return "OK";
    }

    @GetMapping("/tweets")
    public List<TweetModel> listTweets(){
        return tweetRepository.findAll();
    }
}
