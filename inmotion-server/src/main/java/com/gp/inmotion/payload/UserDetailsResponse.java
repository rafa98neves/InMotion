package com.gp.inmotion.payload;

public class UserDetailsResponse {
    private Long id;

    private String name;

    private String email;


    public UserDetailsResponse() {
    }

    public UserDetailsResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
