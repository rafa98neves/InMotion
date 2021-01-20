package com.gp.inmotion.repository;

import com.gp.inmotion.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Optional<Patient> findById(Long id);
    Optional<Patient> findByNumber(Long number);
    Optional<Patient> findByEmail(String email);
    List<Patient> findAllByEnabled(boolean enabled);
}
