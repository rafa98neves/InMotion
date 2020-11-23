package com.gp.inmotion.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends User{

    @Column(length = 64)
    private String patientName;

    @Column(length = 20)
    private String patientGender;

    @Column(length = 64)
    private String patientDiagnosis;

    @ManyToMany()
    private List<Medication> patientMedication;

    @ManyToOne()
    private Therapist therapist;


    public Patient(){
    }

    public Patient(String email, String password, String patientName) {
        super(email, password);
        this.patientName = patientName;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
