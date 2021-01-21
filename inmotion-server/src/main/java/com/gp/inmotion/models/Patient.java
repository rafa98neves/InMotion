package com.gp.inmotion.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patients")
public class Patient extends User{

    @NotNull
    private Long number;

    private String diagnosis;

    @ManyToMany()
    private List<Medication> medicationList;

    @ManyToOne()
    private Therapist therapist;

    @ManyToMany
    private List<Game> recommendedGames;

    public Patient(){
    }

    public Patient(User user, Long number, String diagnosis) {
        super(user.getEmail(), user.getPassword(), user.getName(), user.getGender(), user.getBirthdate(), user.getRole());
        this.setEnabled(true);
        this.number = number;
        this.diagnosis = diagnosis;
        medicationList = new ArrayList<>();
        recommendedGames = new ArrayList<>();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long patientId) {
        this.number = patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setPatientDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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

    public List<Game> getRecommendedGames() {
        return recommendedGames;
    }

    public void setRecommendedGames(List<Game> recommendedGames) {
        this.recommendedGames = recommendedGames;
    }
}
