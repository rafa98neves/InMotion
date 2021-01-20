package com.gp.inmotion.payload;

import com.gp.inmotion.security.ApplicationUserRole;

public class WhoAmIResponse {
    private Long id;

    private String name;

    private ApplicationUserRole role;

    public WhoAmIResponse(){

    }

    public WhoAmIResponse(Long id, String name, ApplicationUserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationUserRole getRole() {
        return role;
    }

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
