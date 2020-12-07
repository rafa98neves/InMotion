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

    public PatientDetailsResponse getPatientDetails(Long patientId){
        Patient patient = getPatient(patientId);

        //here you should transform the patient into a PatientDetailsResponse


        //Here you should return the PatientDetailsResponse you just created
        return new PatientDetailsResponse();
    }
}
