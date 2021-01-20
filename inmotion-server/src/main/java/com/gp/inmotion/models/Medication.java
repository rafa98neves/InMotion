package com.gp.inmotion.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "medicationList")
    private List<Patient> patientList;


    public Medication(){}

    public Medication(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setMedicationId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
