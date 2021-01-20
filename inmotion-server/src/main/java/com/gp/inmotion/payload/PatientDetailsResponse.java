package com.gp.inmotion.payload;

import com.gp.inmotion.models.Medication;

import java.util.*;
import java.util.Date;

public class PatientDetailsResponse extends UserDetailsResponse{
    private String gender;

    private Date birthdate;

    private String diagnosis;

    private Long number;

    private List<Medication> medicationList;

    public PatientDetailsResponse() {
    }

    public PatientDetailsResponse(Long id,
                                  String name,
                                  String gender,
                                  String email,
                                  Date birthdate,
                                  String diagnosis,
                                  Long number,
                                  List<Medication> medicationList) {
        super(id, name, email);
        this.gender = gender;
        this.birthdate = birthdate;
        this.diagnosis = diagnosis;
        this.number = number;
        this.medicationList = medicationList;
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
    }
