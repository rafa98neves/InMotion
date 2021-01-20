package com.gp.inmotion.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp.inmotion.exceptions.GameNotFoundException;
import com.gp.inmotion.models.Game;
import com.gp.inmotion.models.GamePlayed;
import com.gp.inmotion.payload.PatientDetailsResponse;
import com.gp.inmotion.payload.ScoreRequest;
import com.gp.inmotion.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/{patientId}")
    public PatientDetailsResponse findPatientById(@PathVariable("patientId") Long patientId){
        return patientService.findByPatientById(patientId);
    }

    @GetMapping(path = "{patientId}/gamehistory/")
    public List<GamePlayed> getGameHistoryByPatient(@PathVariable("patientId") Long patientId){
        return patientService.getGamesByPatientId(patientId);
    }

    @GetMapping(path = "/gamehistory")
    public List<GamePlayed> getGameHistory(){
        return patientService.getGamesByPatient();
    }

    @GetMapping(path = "/recommendedgames")
    public List<Game> getRecommendedGames(){
        return patientService.getRecommendedGames();
    }

    @PostMapping(path = "/{patientNumber}/games/{gameId}")
    public void playGame(HttpServletRequest request, @PathVariable("patientNumber") Long patientNumber, @PathVariable("gameId") Long gameId){
        try{
            ScoreRequest scoreRequest = new ObjectMapper().readValue(request.getInputStream(), ScoreRequest.class);
            patientService.playGame(gameId, patientNumber, scoreRequest);
        }catch (IOException ioExc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request", ioExc);
        }catch (GameNotFoundException gnfExc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game was not found!", gnfExc);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }

    @GetMapping(path = "/{patientId}/recommendedgames/")
    public List<Game> getRecommendedGames(@PathVariable("patientId") Long patientId){
        return patientService.getRecommendedGames(patientId);
    }
}
