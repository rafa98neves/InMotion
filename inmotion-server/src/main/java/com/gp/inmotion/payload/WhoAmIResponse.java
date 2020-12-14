package com.gp.inmotion.payload;

public class WhoAmIResponse {
    private String name;

    private String role;

    public WhoAmIResponse(){

    }

    public WhoAmIResponse(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
