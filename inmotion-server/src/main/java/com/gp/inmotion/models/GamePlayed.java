package com.gp.inmotion.models;

import javax.persistence.*;

@Entity
@Table(name = "gamesplayed")
public class GamePlayed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient player;

    @ManyToOne
    private Game game;

    private Integer score;


    public GamePlayed() {
    }

    public GamePlayed(Patient player, Game game, Integer score) {
        this.player = player;
        this.game = game;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPlayer() {
        return player;
    }

    public void setPlayer(Patient player) {
        this.player = player;
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
