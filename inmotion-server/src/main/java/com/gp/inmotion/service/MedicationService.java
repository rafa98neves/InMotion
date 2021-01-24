package com.gp.inmotion.service;

import com.gp.inmotion.exceptions.MedicationNotFoundException;
import com.gp.inmotion.models.Medication;
import com.gp.inmotion.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getMedications(){
        return medicationRepository.findAll();
    }

    public Medication getMedication(Long id) throws MedicationNotFoundException{
        return medicationRepository.findById(id).orElseThrow(
                () -> new MedicationNotFoundException("Medication with id " + id + " was not found!")
        );
    }
}
