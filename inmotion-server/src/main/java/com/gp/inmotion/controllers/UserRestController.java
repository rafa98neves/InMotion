package com.gp.inmotion.controllers;

import com.gp.inmotion.controllers.requests.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("api/user")
public class UserRestController {

    @GetMapping("/test")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials loginForm){
        System.out.println(loginForm.getEmail());
        System.out.println(loginForm.getPassword());

        return new ResponseEntity<String>("token", HttpStatus.OK);
    }
}
