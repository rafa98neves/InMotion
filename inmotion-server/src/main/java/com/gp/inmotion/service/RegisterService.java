package com.gp.inmotion.service;

import com.gp.inmotion.models.Patient;
import com.gp.inmotion.models.Role;
import com.gp.inmotion.models.Therapist;
import com.gp.inmotion.models.User;
import com.gp.inmotion.payload.RegisterRequest;
import com.gp.inmotion.repository.PatientRepository;
import com.gp.inmotion.repository.RoleRepository;
import com.gp.inmotion.repository.TherapistRepository;
import com.gp.inmotion.repository.UserRepository;
import com.gp.inmotion.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.gp.inmotion.security.ApplicationUserRole.PATIENT;
import static com.gp.inmotion.security.ApplicationUserRole.THERAPIST;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final TherapistRepository therapistRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(UserRepository userRepository, PatientRepository patientRepository, TherapistRepository therapistRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.therapistRepository = therapistRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest registerRequest){

        Role role = null;
        User user = new User(registerRequest.getId(),
                registerRequest.getEmail(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getName(),
                registerRequest.getGender(),
                registerRequest.getBirthdate(),
                role);

        String requestRole = registerRequest.getRole();

        if(requestRole.equals("THERAPIST")){
            role = findRole(THERAPIST);
            user.setRole(role);
            therapistRepository.save(new Therapist(user));

        }else if(requestRole.equals("PATIENT")){
            role = findRole(PATIENT);
            user.setRole(role);
            patientRepository.save(new Patient(user));
        }
    }

    public Role findRole(ApplicationUserRole role){
        return roleRepository.findByName(role);
    }
}
