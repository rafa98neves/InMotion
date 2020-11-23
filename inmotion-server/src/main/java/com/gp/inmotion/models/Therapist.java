package com.gp.inmotion.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "therapists")
public class Therapist extends User{
    @Column(length = 64)
    private String therapistName;

    @Column(length = 9)
    private String therapistContact;

    @OneToMany(mappedBy = "therapist")
    private List<Patient> patientList;

    public Therapist(){

    }

    public Therapist(String email, String password,  String therapistName, String therapistContact, List<Patient> patientList) {
        super(email, password);
        this.therapistName = therapistName;
        this.therapistContact = therapistContact;
        this.patientList = patientList;
    }


    public String getTherapistName() {
        return therapistName;
    }

    public void setTherapistName(String terapistName) {
        this.therapistName = terapistName;
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
