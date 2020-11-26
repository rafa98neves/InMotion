package com.gp.inmotion.models;

import com.gp.inmotion.security.ApplicationUserRole;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ApplicationUserRole name;

    @OneToMany(mappedBy = "role")
    private List<User> userList;

    public Role() {

    }

    public Role(ApplicationUserRole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationUserRole getName() {
        return name;
    }

    public void setName(ApplicationUserRole name) {
        this.name = name;
    }

}