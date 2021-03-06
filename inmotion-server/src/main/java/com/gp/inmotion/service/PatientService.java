package com.gp.inmotion.service;

import com.gp.inmotion.exceptions.GameNotFoundException;
import com.gp.inmotion.models.Game;
import com.gp.inmotion.models.GamePlayed;
import com.gp.inmotion.models.Patient;
import com.gp.inmotion.payload.GamesPlayedResponse;
import com.gp.inmotion.payload.PatientDetailsResponse;
import com.gp.inmotion.payload.ScoreRequest;
import com.gp.inmotion.repository.GamePlayedRepository;
import com.gp.inmotion.repository.GameRepository;
import com.gp.inmotion.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PatientService {

    private final GamePlayedRepository gamePlayedRepository;
    private final PatientRepository patientRepository;
    private final GameRepository gameRepository;

    @Autowired
    public PatientService(GamePlayedRepository gamePlayedRepository, PatientRepository patientRepository, GameRepository gameRepository) {
        this.gamePlayedRepository = gamePlayedRepository;
        this.patientRepository = patientRepository;
        this.gameRepository = gameRepository;
    }

    private Patient getPatient(Long patientId){
        return patientRepository.findById(patientId).orElseThrow(
                () -> new UsernameNotFoundException("Patient with id " + patientId + " was not found!")
        );
    }

    public PatientDetailsResponse findByPatientById(Long patientId){
        Patient patient = getPatient(patientId);
        return new PatientDetailsResponse(
                patient.getId(),
                patient.getName(),
                patient.getGender(),
                patient.getEmail(),
                patient.getBirthdate(),
                patient.getDiagnosis(),
                patient.getNumber(),
                patient.getMedicationList());
    }


    public List<GamesPlayedResponse> getGamesByPatientId(Long patientId) {
        Patient patient = getPatient(patientId);
        List<GamePlayed> gamesPlayed = gamePlayedRepository.getAllByPlayer(patient);
        List<GamesPlayedResponse> responses = new ArrayList<>();

        for(GamePlayed gamePlayed : gamesPlayed){
            responses.add(new GamesPlayedResponse(gamePlayed.getGame(), gamePlayed.getScore()));
        }

        return responses;
    }


    public List<GamesPlayedResponse> getGamesByPatient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findByEmail((String) authentication.getPrincipal()).orElseThrow(
                () -> new UsernameNotFoundException("Token is invalid!")
        );

        List<GamePlayed> gamesPlayed = gamePlayedRepository.getAllByPlayer(patient);
        List<GamesPlayedResponse> responses = new ArrayList<>();

        for(GamePlayed gamePlayed : gamesPlayed){
            responses.add(new GamesPlayedResponse(gamePlayed.getGame(), gamePlayed.getScore()));
        }
        return responses;
    }

    public void playGame(Long gameId, ScoreRequest playGameRequest) throws GameNotFoundException{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findByEmail((String) authentication.getPrincipal()).orElseThrow(
                () -> new UsernameNotFoundException("Token is invalid!")
        );

        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new GameNotFoundException("Game with id " + gameId + " was not found!")
        );

        GamePlayed gamePlayed = new GamePlayed(patient, game, playGameRequest.getScore());
        gamePlayedRepository.save(gamePlayed);
    }


    public List<Game> getRecommendedGames(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = patientRepository.findByEmail((String) authentication.getPrincipal()).orElseThrow(
                () -> new UsernameNotFoundException("Token is invalid!")
        );

        return patient.getRecommendedGames();
    }

    public List<Game> getRecommendedGames(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new UsernameNotFoundException("Patient with id " + patientId + " was not found!")
        );

        return patient.getRecommendedGames();
    }
}
