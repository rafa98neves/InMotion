package com.gp.inmotion.repository;

import com.gp.inmotion.models.Patient;
import com.gp.inmotion.models.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, String> {
    Optional<Therapist> findById(Long id);
    Optional<Therapist> findByEmail(String email);
    List<Therapist> findAllByEnabled(boolean enabled);
}
