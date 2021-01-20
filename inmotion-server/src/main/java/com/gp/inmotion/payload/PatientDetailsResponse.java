package com.gp.inmotion.payload;

import com.gp.inmotion.models.Medication;

import java.util.*;
import java.util.Date;

public class PatientDetailsResponse {

    private String name;

    private String gender;

    private String email;

    private Date birthdate;

    private String diagnosis;

    private List<Medication> medicationList;

    public PatientDetailsResponse() {
    }

    public PatientDetailsResponse(String name, String gender, String email, Date birthdate, String diagnosis, List<Medication> medicationList) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthdate = birthdate;
        this.diagnosis = diagnosis;
        this.medicationList = medicationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
