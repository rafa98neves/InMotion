package com.gp.inmotion.service;

import com.gp.inmotion.mail.EmailConfig;
import com.gp.inmotion.mail.SendMail;
import com.gp.inmotion.models.*;
import com.gp.inmotion.payload.RegisterRequest;
import com.gp.inmotion.repository.*;
import com.gp.inmotion.exceptions.*;
import com.gp.inmotion.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static com.gp.inmotion.security.ApplicationUserRole.PATIENT;
import static com.gp.inmotion.security.ApplicationUserRole.THERAPIST;

@Service
public class UserService{

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final TherapistRepository therapistRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailConfig emailConfig;
    private final PasswordTokenRepository passwordTokenRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       PatientRepository patientRepository,
                       TherapistRepository therapistRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       EmailConfig emailConfig, PasswordTokenRepository passwordTokenRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.therapistRepository = therapistRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailConfig = emailConfig;
        this.passwordTokenRepository = passwordTokenRepository;
    }

    public void register(RegisterRequest registerRequest) throws UserAlreadyExistsException{
        boolean exists = userRepository.existsByEmail(registerRequest.getEmail());

        if(!exists){
            Role role = null;
            User user = new User(registerRequest.getEmail(),
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
                patientRepository.save(new Patient(user, registerRequest.getPatientId()));
            }
        }else{
            throw new UserAlreadyExistsException("An account with that email already exists!");
        }
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User with email " + email + " not found!")
        );
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = passwordTokenRepository.findByUser(user);
        if(myToken != null){
            myToken.setToken(token);
            myToken.setExpiryDate();
        }else{
            myToken = new PasswordResetToken(token, user);
        }
        passwordTokenRepository.save(myToken);
    }

    public Role findRole(ApplicationUserRole role){
        return roleRepository.findByName(role);
    }

    public void sendToken(String contextPath, String token, User user){
        sendEmail(constructResetTokenEmail(contextPath, token, user));
    }

    private void sendEmail(SimpleMailMessage mailMessage){
        SendMail mailSender = new SendMail(emailConfig, mailMessage);
        mailSender.start();
    }

    private SimpleMailMessage constructResetTokenEmail(String contextPath, String token, User user){
        String url = contextPath + "?token=" + token + "&email=" + user.getEmail();
        String subject = "Reset your password";
        String message = "Hello, \n\n Click on the link below to reset your password.\n\n " + url + "\n\n Sincerely,\n Inmotion Team";
        return constructEmail(subject, message, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, User user){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom(emailConfig.getSource());
        return mailMessage;
    }

    public void validateResetPasswordToken(String token) throws BadTokenException{
        final PasswordResetToken passwordResetToken = passwordTokenRepository.findByToken(token);

        String result =  !isTokenFound(passwordResetToken) ? "invalid"
                : isTokenExpired(passwordResetToken) ? "expired"
                : "valid";

        if(!result.equals("valid")){
            throw new BadTokenException("Password Reset Token is " + result);
        }
    }

    private boolean isTokenFound(PasswordResetToken passwordResetToken){
        return passwordResetToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passwordResetToken){
        final Calendar cal = Calendar.getInstance();
        return passwordResetToken.getExpiryDate().before(cal.getTime());
    }

    public void changePassword(String token, String email, String password) throws BadTokenException{
        validateResetPasswordToken(token);
        final PasswordResetToken passwordResetToken = passwordTokenRepository.findByToken(token);
        final User user = passwordResetToken.getUser();
        if(user.getEmail().equals(email)){
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            passwordTokenRepository.delete(passwordResetToken);
        }else{
            throw new BadTokenException("Password Reset Token for user with email " + email + " not found!");
        }
    }
}