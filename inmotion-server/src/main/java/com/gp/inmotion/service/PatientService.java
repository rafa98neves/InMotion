package com.gp.inmotion.service;

import com.gp.inmotion.models.Patient;
import com.gp.inmotion.payload.PatientDetailsResponse;
import com.gp.inmotion.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private Patient getPatient(Long patientId){
        return patientRepository.findByPatientId(patientId).orElseThrow(
                () -> new UsernameNotFoundException("Patient with id " + patientId + " was not found!")
        );
    }

    public PatientDetailsResponse findByPatientById(Long patientId){
        Patient patient = getPatient(patientId);
        return new PatientDetailsResponse(patient.getName(),patient.getGender(), patient.getEmail(), patient.getBirthdate(), patient.getPatientDiagnosis(), patient.getMedicationList());
    }


}
