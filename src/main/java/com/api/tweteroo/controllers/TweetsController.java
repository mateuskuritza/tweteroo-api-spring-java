package com.api.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.dtos.TweetDTO;
import com.api.tweteroo.models.Tweet;
import com.api.tweteroo.repositories.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetRepository tweetRepository;
    
    @PostMapping
    public String create(@RequestBody TweetDTO tweet){
        tweetRepository.save(new Tweet(tweet));
        return "OK";
    }
}
