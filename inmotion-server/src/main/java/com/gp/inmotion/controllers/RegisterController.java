package com.gp.inmotion.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp.inmotion.payload.RegisterRequest;
import com.gp.inmotion.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping()
    public void registerPatient(HttpServletRequest request){
        try{
            RegisterRequest registerRequest = new ObjectMapper().readValue(request.getInputStream(), RegisterRequest.class);
            registerService.register(registerRequest);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
