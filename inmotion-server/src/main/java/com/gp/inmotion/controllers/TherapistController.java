package com.gp.inmotion.controllers;

import com.gp.inmotion.exceptions.GameNotFoundException;
import com.gp.inmotion.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/therapist")
public class TherapistController {

    private final TherapistService therapistService;

    @Autowired
    public TherapistController(TherapistService therapistService) {
        this.therapistService = therapistService;
    }


    @PostMapping(path = "/patients/{patientId}/recommendedgames/{gameId}")
    public void recommendGame(@PathVariable("patiendId") Long patientId, @PathVariable("gameId") Long gameId){
        try{
            therapistService.recommendGame(patientId, gameId);
        }catch (UsernameNotFoundException unfExc){

        }catch (GameNotFoundException gnfExc){

        }
    }
}
