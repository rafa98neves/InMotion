package com.gp.inmotion.controllers;


import com.gp.inmotion.payload.UserDetailsResponse;
import com.gp.inmotion.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/management")
public class AdminController {

    private final ManagementService managementService;

    @Autowired
    public AdminController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping(path = "/therapists")
    public List<UserDetailsResponse> getTherapists(){
        return managementService.getTherapists();
    }

    @PostMapping(path = "therapists/{userId}/activate")
    public void activateUser(@PathVariable("userId") Long userId){
        managementService.activateTherapist(userId);
    }

    @PostMapping(path = "therapists/{userId}/reject")
    public void rejectUser(@PathVariable("userId") Long userId){
        managementService.rejectTherapist(userId);
    }


}
