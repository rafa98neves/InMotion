package com.gp.inmotion.payload;

import javax.persistence.Column;
import java.util.Date;

public class PatientDetailsResponse {

    private String name;

    private String gender;

    private Date birthdate;

    private String patientDiagnosis;

    public PatientDetailsResponse() {
    }

    public PatientDetailsResponse(String name, String gender, Date birthdate, String patientDiagnosis) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.patientDiagnosis = patientDiagnosis;
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
}
