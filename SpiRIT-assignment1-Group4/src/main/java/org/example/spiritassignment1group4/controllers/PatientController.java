package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.PatientServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {
    private PatientServices patientServices;
    public PatientController(PatientServices patientServices) {
        this.patientServices = patientServices;
    }

    @GetMapping("/patient")
    public String getPatients(Model model) {
        model.addAttribute("patients", patientServices.getPatients());
        return "patient-list";
    }

    @GetMapping("/patient/add")
    public String showAddPatientForm() {
        return "add-patient";
    }

    @PostMapping("/patient/add")
    public String addPatient(@RequestParam String name,
                             @RequestParam int patientID) {

        Patient patient = new Patient(name, patientID);
        patientServices.addPatient(patient);

        return "redirect:/patient";
    }
}