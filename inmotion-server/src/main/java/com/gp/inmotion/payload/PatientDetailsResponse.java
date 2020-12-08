package com.gp.inmotion.payload;

import com.gp.inmotion.models.Patient;

import javax.persistence.Column;
import java.util.Date;

public class PatientDetailsResponse {

    @Column(length = 64)
    private String name;

    @Column(length = 20)
    private String gender;

    @Column()
    private Date birthdate;

    @Column(length = 64)
    private String patientDiagnosis;

    public PatientDetailsResponse() {
    }

    public PatientDetailsResponse(String name, String gender, Date birthdate, String patientDiagnosis) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.patientDiagnosis = patientDiagnosis;
    }
}
