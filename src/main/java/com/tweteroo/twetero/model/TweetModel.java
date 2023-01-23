package com.tweteroo.twetero.model;

import com.tweteroo.twetero.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class TweetModel {
    
    public TweetModel(TweetDTO data, String avatar,String username){
        this.avatar = avatar;
        this.text = data.text();
        this.username = username;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = true)
    private String username;

    @Column(length = 400, nullable = true)
    private String avatar;

    @Column(length = 256, nullable = false)
    private String text;
}
