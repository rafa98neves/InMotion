package com.gp.inmotion.payload;

import com.gp.inmotion.models.Patient;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class MedicationDetailsResponse {


    @Column(length = 64)
    private String patientDiagnosis;

    @Column()
    private Long medicationId;

    @Column()
    private String medicationName;


    public MedicationDetailsResponse() {
    }

    public MedicationDetailsResponse(Long medicationId, String medicationName, String patientDiagnosis) {
        this.medicationId = medicationId;
        this.medicationName=medicationName;
        this.patientDiagnosis = patientDiagnosis;
    }
}