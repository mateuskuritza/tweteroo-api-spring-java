package com.api.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

import com.api.tweteroo.dtos.TweetDTO;
import com.api.tweteroo.models.Tweet;
import com.api.tweteroo.repositories.TweetRepository;

@CrossOrigin(origins = "null", maxAge = 3600)
@RestController
@RequestMapping("/api/tweets")
public class TweetsController {

    @Autowired
    private TweetRepository tweetRepository;
    
    @PostMapping
    public ResponseEntity<String> create(@RequestBody TweetDTO text, @RequestHeader("User") String username){
        tweetRepository.save(new Tweet(text, username));
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @GetMapping
    public Page<Tweet> list(@RequestParam(value = "page", defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").descending());
        return tweetRepository.findAll(pageable);
    }

    @GetMapping("/{username}")
    public List<Tweet> byUser(@PathVariable(value = "username") String username){
        Tweet tweet = new Tweet();
        tweet.setUsername(username);
        Example<Tweet> tweetExample = Example.of(tweet);
        return tweetRepository.findAll(tweetExample);
    }
}
