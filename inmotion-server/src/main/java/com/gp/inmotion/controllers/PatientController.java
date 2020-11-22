package com.gp.inmotion.controllers;

import com.gp.inmotion.models.Patient;
import com.gp.inmotion.repository.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    PatientRepository patientRepository;

    @GetMapping(path = "/{patientId}")
    public Patient getPatient(@PathVariable("patientId") Long patientId){
        return patientRepository.findByPatientId(patientId);
    }
}
