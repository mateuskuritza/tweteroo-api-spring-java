package com.api.tweteroo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.dtos.UserDTO;

@RestController
@RequestMapping("/")
public class UsersController {
    @PostMapping("sign-up")
    public String signUp(@RequestBody UserDTO user){
        return "OK";
    }
}
