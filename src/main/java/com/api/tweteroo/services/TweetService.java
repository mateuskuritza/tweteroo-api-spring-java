package com.api.tweteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.tweteroo.dtos.TweetDTO;
import com.api.tweteroo.models.Person;
import com.api.tweteroo.models.Tweet;
import com.api.tweteroo.repositories.PersonRepository;
import com.api.tweteroo.repositories.TweetRepository;

@Service
public class TweetService {
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    PersonRepository personRepository;

    public void createNew(TweetDTO tweet, String username) {
        List<Person> persons = personRepository.findByUsername(username);
        if (persons.isEmpty())
            return;

        String avatar = persons.get(0).getAvatar();
        tweetRepository.save(new Tweet(tweet, username, avatar));
    }

    public Page<Tweet> getTweetsOfPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        return tweetRepository.findAll(pageable);
    }

    public List<Tweet> getTweetsOfPerson(String username) {
        return tweetRepository.findByUsername(username);
    }
}
