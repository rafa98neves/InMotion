package com.gp.inmotion.payload;

import java.util.Date;

public class UserDetailsResponse {

    private String name;

    private String gender;

    private String email;

    private Date birthdate;

    public UserDetailsResponse() {
    }

    public UserDetailsResponse(String name, String gender, String email, Date birthdate) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
