package com.gp.inmotion.service;

import com.gp.inmotion.models.Therapist;
import com.gp.inmotion.payload.UserDetailsResponse;
import com.gp.inmotion.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ManagementService {

    private final TherapistRepository therapistRepository;

    @Autowired
    public ManagementService(TherapistRepository therapistRepository) {
        this.therapistRepository = therapistRepository;
    }

    public void activateTherapist(Long userId){
        Therapist therapist = therapistRepository.findById(userId).orElseThrow(
            () -> new UsernameNotFoundException("Therapist with id " + userId + " was not found!"));
        therapist.setEnabled(true);
        therapistRepository.save(therapist);
    }

    public void rejectTherapist(Long userId){
        Therapist therapist = therapistRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("Therapist with id " + userId + " was not found!"));
        therapistRepository.delete(therapist);
    }

    public List<UserDetailsResponse> getTherapists(){
        List<Therapist> therapists = therapistRepository.findAllByEnabled(false);
        List<UserDetailsResponse> response = new ArrayList<>();
        for(Therapist therapist : therapists){
            response.add(new UserDetailsResponse(therapist.getId(), therapist.getName(), therapist.getEmail()));
        }
        return response;
    }
}
