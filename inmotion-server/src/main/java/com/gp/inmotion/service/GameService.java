package com.gp.inmotion.service;

import com.gp.inmotion.exceptions.GameNotFoundException;
import com.gp.inmotion.models.Game;
import com.gp.inmotion.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game findById(Long gameId) throws GameNotFoundException {
        return gameRepository.findById(gameId).orElseThrow(
                () -> new GameNotFoundException("Game with id " + gameId + " was not found!")
        );
    }
}
