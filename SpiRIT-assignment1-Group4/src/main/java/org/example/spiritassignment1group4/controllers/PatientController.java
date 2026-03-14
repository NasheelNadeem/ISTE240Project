package org.example.spiritassignment1group4.controllers;


import org.example.spiritassignment1group4.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController {

    private List<Patient> patients = new ArrayList<>();

    @GetMapping("/patient")
    public String getPatients(Model model) {
        model.addAttribute("patients", patients);
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
        patients.add(patient);

        return "redirect:/patient";
    }
}