package com.tweteroo.twetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.twetero.model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
    
}
