package com.gp.inmotion.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patients")
public class Patient extends User{

    @Column
    @NotNull
    private Long patientId;

    @Column(length = 64)
    private String patientDiagnosis;

    @ManyToOne()
    private Medication medication;

    @ManyToOne()
    private Therapist therapist;


    public Patient(){
    }

    public Patient(User user, Long patientId){
        super(user.getEmail(), user.getPassword(), user.getName(), user.getGender(), user.getBirthdate(), user.getRole());
        this.patientId = patientId;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
