package com.gp.inmotion.payload;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class RegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    private Long id;

    @NotBlank
    private String role;

    @NotBlank
    private Date birthdate;

    @NotBlank
    private String gender;

    @NotBlank
    private String email;

    @NotBlank
    private String password;


    public RegisterRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
