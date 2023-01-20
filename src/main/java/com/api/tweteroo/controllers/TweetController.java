package com.api.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.api.tweteroo.services.TweetService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "null", maxAge = 3600)
@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid TweetDTO tweet,
            @RequestHeader("User") String username) {
        tweetService.createNew(tweet, username);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @GetMapping
    public Page<Tweet> list(@RequestParam(value = "page", defaultValue = "0") int page) {
        return tweetService.getTweetsOfPage(page, 5);
    }

    @GetMapping("/{username}")
    public List<Tweet> byPerson(@PathVariable(value = "username") String username) {
        return tweetService.getTweetsOfPerson(username);
    }
}
