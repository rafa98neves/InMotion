package com.gp.inmotion.service;

import com.gp.inmotion.exceptions.GameNotFoundException;
import com.gp.inmotion.models.Game;
import com.gp.inmotion.models.Patient;
import com.gp.inmotion.repository.GameRepository;
import com.gp.inmotion.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TherapistService {

    private final PatientRepository patientRepository;
    private final GameRepository gameRepository;

    @Autowired
    public TherapistService(PatientRepository patientRepository, GameRepository gameRepository) {
        this.patientRepository = patientRepository;
        this.gameRepository = gameRepository;
    }

    public void recommendGame(Long patientId, Long gameId) throws UsernameNotFoundException, GameNotFoundException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new UsernameNotFoundException("Patient with id " + patientId + "was not found!")
        );

        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new GameNotFoundException("Game with id " + gameId + " was not found!")
        );

        patient.getRecommendedGames().add(game);

        patientRepository.save(patient);
    }

}
