/*
 * Student Name: Ryan Benson
 * UID: 421007591
 */
package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);

        if (patient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(patient.get());
    }

    @GetMapping("/search")
    public List<Patient> searchPatientsByName(@RequestParam(required = false) String name) {
        if (name != null && !name.isBlank()) {
            // Using your custom JPQL search from the repository
            return patientService.searchPatientsByNameCustom(name);
        }
        return patientService.getAllPatients();
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody Patient updatedPatient
    ) {
        Optional<Patient> existingPatient = patientService.getPatientById(id);

        if (existingPatient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Patient patient = existingPatient.get();
        patient.setName(updatedPatient.getName());

        Patient savedPatient = patientService.savePatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<String> updatePatientName(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String name = body.get("name");

        if (name == null || name.isBlank()) {
            return ResponseEntity.badRequest().body("Name is required.");
        }

        Optional<Patient> existingPatient = patientService.getPatientById(id);

        if (existingPatient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        patientService.updatePatientNameById(id, name);
        return ResponseEntity.ok("Patient name updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        Optional<Patient> existingPatient = patientService.getPatientById(id);

        if (existingPatient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully.");
    }
}