package com.gp.inmotion.controllers;

import com.gp.inmotion.models.Medication;
import com.gp.inmotion.models.Patient;
import com.gp.inmotion.payload.MedicationDetailsResponse;
import com.gp.inmotion.payload.PatientDetailsResponse;
import com.gp.inmotion.repository.PatientRepository;
import com.gp.inmotion.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patient/medication")
public class MedicationController {

    private final PatientService patientService;

    @Autowired
    public MedicationController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/{patientId}")
    public MedicationDetailsResponse getPatientMedication(@PathVariable("patientId") Long patientId){
        return patientService.getMedicationDetails(patientId);
    }


}