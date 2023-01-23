package com.tweteroo.twetero.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.tweteroo.twetero.dto.TweetDTO;
import com.tweteroo.twetero.model.TweetModel;
import com.tweteroo.twetero.repository.TweetRepository;
import com.tweteroo.twetero.repository.UserRepository;

@Service
public class TweetService extends UserService {
    private List<List<TweetModel>> tweetList = new ArrayList<>();

    @Autowired
    private TweetRepository tweetRepository;
    

    public void newTweet(TweetDTO req,String username){

        tweetRepository.save(new TweetModel(req,this.findAvatar(username),username ));
        // tweetList.add(new TweetModel(req,this.findAvatar(req.username())));
    }
    
    
    public List<TweetModel> listTweets(){
        return tweetRepository.findAll();  
          
    }
}
