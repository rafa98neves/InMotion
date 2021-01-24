package com.gp.inmotion.controllers;

import com.gp.inmotion.exceptions.MedicationNotFoundException;
import com.gp.inmotion.models.Medication;
import com.gp.inmotion.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping
    public List<Medication> getMedications(){
        return  medicationService.getMedications();
    }

    @GetMapping("/{medicationId}")
    public Medication getMedicationById(@PathVariable("medicationId") Long medicationId){
        try{
            return medicationService.getMedication(medicationId);
        }catch (MedicationNotFoundException mnfExc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Medication not found", mnfExc);
        }
    }
}
