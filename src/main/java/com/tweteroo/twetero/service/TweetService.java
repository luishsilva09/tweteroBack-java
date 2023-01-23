package com.tweteroo.twetero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tweteroo.twetero.dto.TweetDTO;
import com.tweteroo.twetero.model.TweetModel;
import com.tweteroo.twetero.repository.TweetRepository;

@Service
public class TweetService extends UserService {
    @Autowired
    private TweetRepository tweetRepository;
    

    public void newTweet(TweetDTO req,String username){
        tweetRepository.save(new TweetModel(req,this.findAvatar(username),username ));
    }
    
    
    public Page<TweetModel> listTweets(Pageable page){
        return tweetRepository.findAll(page);  
          
    }

    public List<TweetModel> listUserTweets(String username){
        if(this.existUsername(username)) throw new ResponseStatusException(HttpStatus.CONFLICT);
        return tweetRepository.findByUsername(username);
    }
}
