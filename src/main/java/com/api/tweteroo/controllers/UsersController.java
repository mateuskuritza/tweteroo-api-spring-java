package com.api.tweteroo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.dtos.UserDTO;

import jakarta.validation.Valid;

@CrossOrigin(origins = "null", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class UsersController {
    @PostMapping("sign-up")
    public String signUp(@RequestBody @Valid UserDTO user) {
        return "OK";
    }
}
