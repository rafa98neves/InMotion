package com.gp.inmotion.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;

    @Column()
    private String medicationName;

    @OneToMany(mappedBy = "medication")
    private List<Patient> patientList;


    public Medication(){}

    public Medication(Long medicationId, String medicationName) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
