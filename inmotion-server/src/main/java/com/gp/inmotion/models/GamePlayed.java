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

    private Integer time;

    public GamePlayed() {
    }

    public GamePlayed(Patient player, Game game, Integer score, Integer time) {
        this.player = player;
        this.game = game;
        this.score = score;
        this.time = time;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
