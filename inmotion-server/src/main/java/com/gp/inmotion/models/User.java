package com.gp.inmotion.models;

import com.gp.inmotion.security.ApplicationUserRole;
import org.checkerframework.common.value.qual.IntRangeFromNonNegative;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @Column(length = 60)
    private String email;

    @NotBlank
    @Column(length = 100)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    public User(){};

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
