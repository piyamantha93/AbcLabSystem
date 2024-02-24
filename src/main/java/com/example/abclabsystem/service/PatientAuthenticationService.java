package com.example.abclabsystem.service;

import com.example.abclabsystem.entity.AuthenticationTokenPatient;
import com.example.abclabsystem.entity.Patient;
import com.example.abclabsystem.exceptions.AuthenticationFailException;
import com.example.abclabsystem.repos.PatientTokenRepo;
import com.example.abclabsystem.util.Helper;
import com.example.abclabsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PatientAuthenticationService {
    @Autowired
    private PatientTokenRepo patientTokenRepo;


    public void saveConfirmationToken(AuthenticationTokenPatient authenticationTokenPatient) {
        patientTokenRepo.save(authenticationTokenPatient);
    }

    public AuthenticationTokenPatient getPatientToken(Optional<Patient> patient) {
        return patientTokenRepo.findTokenByPatient(patient);
    }

    public Patient getPatient(String token) {
        AuthenticationTokenPatient authenticationTokenPatient = patientTokenRepo.findTokenByPatientToken(token);
        if (Helper.notNull(authenticationTokenPatient)) {
            if (Helper.notNull(authenticationTokenPatient.getPatient())) {
                return authenticationTokenPatient.getPatient();
            }
        }
        return null;
    }

    public void authenticate(String token) throws AuthenticationFailException {
        if (!Helper.notNull(token)) {
            throw new AuthenticationFailException(VarList.AUTH_TOEKN_NOT_PRESENT);
        }
        if (!Helper.notNull(getPatient(token))) {
            throw new AuthenticationFailException(VarList.AUTH_TOEKN_NOT_VALID);
        }
    }

//    public void deleteTokenByUserId(Long userId) throws AuthenticationFailException{
//        // Find the token associated with the consultant ID
//        Optional<AuthenticationTokenPatient> tokenOptional = patientTokenRepo.findByPatientId(userId);
//
//        // Check if a token was found
//        if (tokenOptional.isPresent()) {
//            AuthenticationTokenUser token = tokenOptional.get();
//            userTokenRepo.delete(token); // Delete the token
//        }
//    }
}
