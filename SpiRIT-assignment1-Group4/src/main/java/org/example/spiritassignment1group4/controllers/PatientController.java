package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.ProjectServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {
    private final ProjectServices projectServices;

    public PatientController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping("/patients")
    public String getPatients(Model model) {
        model.addAttribute("patients", projectServices.findAllPatients());
        return "patients"; // patients.mustache
    }

    @GetMapping("/addPatient")
    public String showAddPatientForm() {
        return "redirect:/addPatient.html";
    }

    @PostMapping("/addPatient")
    public String addPatient(@RequestParam String name,
                             @RequestParam int patientID) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setPatientId(patientID);

        projectServices.addPatient(patient);

        return "redirect:/add/success/patient";
    }
}