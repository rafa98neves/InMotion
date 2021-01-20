package com.gp.inmotion.controllers;

import com.gp.inmotion.exceptions.GameNotFoundException;
import com.gp.inmotion.models.Game;
import com.gp.inmotion.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("api/v1/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames(){
        return gameService.findAll();
    }

    @GetMapping(path = "/{gameId}")
    public Game findGameById(@PathVariable("gameId") Long gameId){
        try{
            return gameService.findById(gameId);
        }catch (GameNotFoundException gnfe){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Request", gnfe);
        }
    }


}
