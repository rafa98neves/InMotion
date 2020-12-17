package com.gp.inmotion.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp.inmotion.exceptions.BadTokenException;
import com.gp.inmotion.models.User;
import com.gp.inmotion.payload.ChangePasswordRequest;
import com.gp.inmotion.payload.ResetPasswordRequest;
import com.gp.inmotion.payload.ValidateResetPasswordTokenRequest;
import com.gp.inmotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping 
public class ResetPasswordController {
    private final UserService userService;

    @Autowired
    public ResetPasswordController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/resetPassword")
    public void resetPassword(HttpServletRequest request){
        try{
            ResetPasswordRequest resetPasswordRequest = new ObjectMapper().readValue(request.getInputStream(), ResetPasswordRequest.class);
            User user = userService.findUserByEmail(resetPasswordRequest.getEmail());
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);
            userService.sendToken("http://localhost:8080" + request.getServletPath(), token, user);
        }catch (IOException ioException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Request", ioException);
        }catch (UsernameNotFoundException unfException){

        }catch (Exception e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.   INTERNAL_SERVER_ERROR, "", e);
        }
    }

    @PostMapping("/validateToken")
    public void validateResetPasswordToken(HttpServletRequest request){
        try{
            ValidateResetPasswordTokenRequest passwordTokenRequest = new ObjectMapper().readValue(request.getInputStream(), ValidateResetPasswordTokenRequest.class);
            userService.validateResetPasswordToken(passwordTokenRequest.getToken());
        }catch (IOException ioException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Request", ioException);
        }catch (BadTokenException btException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, btException.getMessage(), btException);
        }catch (Exception e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "", e);
        }
    }

    @PostMapping("/changePassword")
    public void changePassword(HttpServletRequest request){
        try{
            ChangePasswordRequest changePasswordRequest = new ObjectMapper().readValue(request.getInputStream(), ChangePasswordRequest.class);
            userService.changePassword(changePasswordRequest.getToken(), changePasswordRequest.getEmail(), changePasswordRequest.getPassword());
        }catch (IOException ioException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Request", ioException);
        }catch (BadTokenException btException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, btException.getMessage(), btException);
        }catch (Exception e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "", e);
        }
    }
}
