package com.gp.inmotion.controllers;

import com.gp.inmotion.models.Patient;
import com.gp.inmotion.payload.PatientDetailsResponse;
import com.gp.inmotion.repository.PatientRepository;
import com.gp.inmotion.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/{patientId}")
    public PatientDetailsResponse getPatient(@PathVariable("patientId") Long patientId){
        return patientService.getPatientDetails(patientId);
    }


}
