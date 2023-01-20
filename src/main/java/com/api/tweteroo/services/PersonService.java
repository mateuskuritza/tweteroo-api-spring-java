package com.api.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tweteroo.dtos.PersonDTO;
import com.api.tweteroo.models.Person;
import com.api.tweteroo.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void signUp(PersonDTO person) {
        personRepository.save(new Person(person));
    }
}
