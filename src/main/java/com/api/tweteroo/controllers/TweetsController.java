package com.api.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public List<Tweet> list(@RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Tweet> tweets = tweetRepository.findAll(pageable);
        return tweets.getContent();
    }

    @GetMapping("/{username}")
    public List<Tweet> byUser(@PathVariable(value = "username") String username){
        Tweet tweet = new Tweet();
        tweet.setUsername(username);
        Example<Tweet> tweetExample = Example.of(tweet);
        return tweetRepository.findAll(tweetExample);
    }
}
