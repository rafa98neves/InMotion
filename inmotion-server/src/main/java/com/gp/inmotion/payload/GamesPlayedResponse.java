package com.gp.inmotion.payload;

import com.gp.inmotion.models.Game;

public class GamesPlayedResponse {

    private Game game;

    private Integer score;

    public GamesPlayedResponse() {
    }

    public GamesPlayedResponse(Game game, Integer score) {
        this.game = game;
        this.score = score;
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
