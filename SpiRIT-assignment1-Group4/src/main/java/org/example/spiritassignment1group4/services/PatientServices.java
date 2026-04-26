/*
 * Student Name: Ryan Benson
 * UID: 421007591
 */
// Ryan Benson 421007591

package org.example.spiritassignment1group4.services;

import jakarta.transaction.Transactional;
import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findPatientsByName(String name) {
        return patientRepository.findByName(name);
    }

    public List<Patient> searchPatientsByNameCustom(String name) {
        return patientRepository.searchByNameCustom(name);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public void updatePatientNameById(Long id, String name) {
        patientRepository.updateNameById(id, name);
    }
}