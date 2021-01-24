package com.gp.inmotion.repository;

import com.gp.inmotion.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findAll();
    Optional<Medication> findById(Long id);
}
