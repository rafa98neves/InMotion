package com.gp.inmotion.repository;

import com.gp.inmotion.models.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, String> {
    Optional<Therapist> findByEmail(String email);
}
