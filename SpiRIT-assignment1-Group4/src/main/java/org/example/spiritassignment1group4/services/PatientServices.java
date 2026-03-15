package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.Patient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServices {

    private List<Patient> patients = new ArrayList<>();

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}