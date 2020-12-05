package com.gp.inmotion.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp.inmotion.exceptions.UserAlreadyExistsException;
import com.gp.inmotion.payload.RegisterRequest;
import com.gp.inmotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerPatient(HttpServletRequest request){
        try{
            RegisterRequest registerRequest = new ObjectMapper().readValue(request.getInputStream(), RegisterRequest.class);
            userService.register(registerRequest);
        }catch (IOException ioException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Request", ioException);
        }catch (UserAlreadyExistsException uaeException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email Already Exists", uaeException);
        }catch (Exception e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "", e);
        }
    }

}
