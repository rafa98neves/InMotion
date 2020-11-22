package com.gp.inmotion.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "terapists")
public class Terapist extends User{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terapistId;

    @Column(length = 64)
    private String terapistName;

    @Column(length = 9)
    private String therapistContact;

    @OneToMany(mappedBy = "therapist")
    private List<Patient> patientList;

    public Terapist(){

    }

    public Terapist(String email, String password, Long terapistId, String terapistName, String therapistContact, List<Patient> patientList) {
        super(email, password);
        this.terapistId = terapistId;
        this.terapistName = terapistName;
        this.therapistContact = therapistContact;
        this.patientList = patientList;
    }

    public Long getTerapistId() {
        return terapistId;
    }

    public String getTerapistName() {
        return terapistName;
    }

    public void setTerapistName(String terapistName) {
        this.terapistName = terapistName;
    }

    public void setTerapistId(Long terapistId) {
        this.terapistId = terapistId;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public String getTherapistContact() {
        return therapistContact;
    }

    public void setTherapistContact(String therapistContact) {
        this.therapistContact = therapistContact;
    }
}
