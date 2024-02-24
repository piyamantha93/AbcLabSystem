package com.example.abclabsystem.service;


import com.example.abclabsystem.dto.PatientDTO;
import com.example.abclabsystem.entity.AuthenticationTokenPatient;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.repos.PatientRepo;
import com.example.abclabsystem.repos.PatientTokenRepo;
import com.example.abclabsystem.util.VarList;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private PasswordHasher passwordHasher;

    @Autowired
    private PatientAuthenticationService patientAuthenticationService;
    @Autowired
    private PatientTokenRepo patientTokenRepo;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = (Logger) LoggerFactory.getLogger(PatientService.class);



    public String signUpPatient(PatientDTO patientDTO) {
        // Check to see if the current email address has already been registered.
        Patient existingUser = patientRepo.findByEmail(patientDTO.getEmail());
        if (existingUser != null) {
            // If the email address has been registered then return a response indicating duplication.
            return VarList.RSP_DUPLICATED;
        }

        // first encrypt the password
        String encryptedPassword = patientDTO.getPassword();
        try {
            encryptedPassword = passwordHasher.hashPassword(patientDTO.getPassword()); // Use the PasswordHasher bean
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("Hashing password failed: {}", e.getMessage());
            // Handle the hashing error here, you can return an appropriate response code
            return VarList.RSP_ERROR;
        }

        Patient patient = new Patient(patientDTO.getfName(), patientDTO.getGender(), patientDTO.getEmail(),  encryptedPassword);

        Patient createdUser;
        try {
            // save the User
            createdUser = patientRepo.save(patient);
            System.out.println(createdUser);
            // generate token for user
            final AuthenticationTokenPatient authenticationTokenPatient = new AuthenticationTokenPatient(createdUser);
            // save token in the database
            patientAuthenticationService.saveConfirmationToken(authenticationTokenPatient);
            // success in creating
            return VarList.RSP_SUCCESS;
        } catch (Exception e) {
            // handle signup error
            return VarList.RSP_ERROR;
        }
    }
}
