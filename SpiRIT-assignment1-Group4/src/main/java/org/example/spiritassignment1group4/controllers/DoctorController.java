package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.services.ProjectServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {
    private final ProjectServices projectService;

    public DoctorController(ProjectServices projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/doctors")
    public String viewDoctors(Model data) {
        data.addAttribute("doctors", projectService.findAllDoctors());
        return "doctors"; // Refers to doctors.mustache
    }


    @GetMapping("/addDoctor")
    public String addDoctorForm() {
        return "redirect:/addDoctor.html";
    }

    @PostMapping("/addDoctor")
    public String addDoctor(
            @RequestParam("name") String name,
            @RequestParam("id") int id,
            @RequestParam("profession") String profession) {

        Doctor newDoctor = new Doctor();
        newDoctor.setName(name);
        newDoctor.setDoctorID(id);
        newDoctor.setProfession(profession);

        projectService.addDoctor(newDoctor);

        return "redirect:/add/success/doctor";
    }
}