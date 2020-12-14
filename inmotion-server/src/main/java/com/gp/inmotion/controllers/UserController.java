package com.gp.inmotion.controllers;

import com.gp.inmotion.payload.WhoAmIResponse;
import com.gp.inmotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/whoami")
    public WhoAmIResponse whoami(){
        return userService.whoami();
    }
}
