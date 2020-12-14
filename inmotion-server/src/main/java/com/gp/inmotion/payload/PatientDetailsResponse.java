package com.gp.inmotion.payload;

import com.gp.inmotion.models.Medication;

import java.util.*;
import java.util.Date;

public class PatientDetailsResponse {

    private String name;

    private String gender;

    private String email;

    private Date birthdate;

    private String patientDiagnosis;

    private List<Medication> medicationList;

    public PatientDetailsResponse() {
    }

    public PatientDetailsResponse(String name, String gender, String email, Date birthdate, String patientDiagnosis, List<Medication> medicationList) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthdate = birthdate;
        this.patientDiagnosis = patientDiagnosis;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
