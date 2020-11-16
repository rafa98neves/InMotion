package com.gp.inmotion.model;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id()
    @Column(length = 64)
    private String email;

    @NonNull
    private String password;
}
