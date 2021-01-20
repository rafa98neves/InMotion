package com.gp.inmotion.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ScoreRequest {

    @NotNull
    @NotEmpty
    private Integer score;

    @NotNull
    @NotEmpty
    private Integer time;

    public ScoreRequest(){

    }

    public Integer getScore() {
        return score;
    }

    public Integer getTime() {
        return time;
    }

}
