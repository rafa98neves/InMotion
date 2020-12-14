package com.gp.inmotion.models;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patients")
public class Patient extends User{

    @Column
    @NotNull
    private Long patientId;

    @Column(length = 64)
    private String patientDiagnosis;

    @ManyToMany()
    private List<Medication> medicationList;

    @ManyToOne()
    private Therapist therapist;


    public Patient(){
    }

    public Patient(User user, Long patientId){
        super(user.getEmail(), user.getPassword(), user.getName(), user.getGender(), user.getBirthdate(), user.getRole());
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

}
