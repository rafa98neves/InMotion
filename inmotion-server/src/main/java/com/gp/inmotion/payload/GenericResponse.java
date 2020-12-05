package com.gp.inmotion.payload;

public class GenericResponse {
    public String message;
    public String error;

    public GenericResponse(String message){
        this.message = message;
    }

    public GenericResponse(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
