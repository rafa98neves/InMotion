package com.gp.inmotion.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "therapists")
public class Therapist extends User{

    @OneToMany(mappedBy = "therapist")
    private List<Patient> patientList;

    public Therapist(){

    }

    public Therapist(User user){
        super(user.getEmail(), user.getPassword(), user.getName(), user.getRole());
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

}
