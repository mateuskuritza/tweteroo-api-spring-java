package com.api.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.dtos.PersonDTO;
import com.api.tweteroo.services.PersonService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "null", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("sign-up")
    public String signUp(@RequestBody @Valid PersonDTO person) {
        personService.signUp(person);
        return "OK";
    }
}
