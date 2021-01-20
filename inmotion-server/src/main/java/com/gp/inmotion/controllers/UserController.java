package com.gp.inmotion.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp.inmotion.payload.UserDetailsResponse;
import com.gp.inmotion.payload.UserUpdateRequest;
import com.gp.inmotion.payload.WhoAmIResponse;
import com.gp.inmotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
@RequestMapping("api/v1/user")
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

    @PostMapping("/update")
    public void updateUser(HttpServletRequest request){
        try{
            UserUpdateRequest updateRequest = new ObjectMapper().readValue(request.getInputStream(), UserUpdateRequest.class);
            userService.updateUser(updateRequest);
        }catch (IOException ioException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Request", ioException);
        }
    }

    @GetMapping("/details")
    public UserDetailsResponse getDetails(){
        return userService.getDetails();
    }

    @PostMapping("/delete")
    public void deleteUser(){
        userService.deleteUser();
    }
}
