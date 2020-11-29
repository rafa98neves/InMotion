package com.gp.inmotion.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends User{

    @Column(length = 64)
    private String patientDiagnosis;

    @ManyToOne()
    private Medication medication;

    @ManyToOne()
    private Therapist therapist;


    public Patient(){
    }

    public Patient(User user){
        super(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getGender(), user.getBirthdate(), user.getRole());
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public Medication getPatientMedication() {
        return medication;
    }

    public void setPatientMedication(Medication medication) {
        this.medication = medication;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }
}
