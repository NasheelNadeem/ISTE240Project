package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.FeedbackServices;
import org.example.spiritassignment1group4.services.ProjectServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {
    private ProjectServices projectServices;

    public FeedbackController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @GetMapping("/feedbacks")
    public String viewFeedback(Model data) {
        data.addAttribute("feedbacks", projectServices.findAllFeedbacks());
        return "feedbacks";
    }

    @GetMapping("/addFeedback")
    public String addFeedbackForm(Model data) {
        return "redirect:addFeedback.html";
    }

    @PostMapping("/addFeedback")
    public String addFeedback(@RequestParam String patient, @RequestParam String doctor, @RequestParam int rating, @RequestParam String comment, Model data) {
        var newPatient = new Patient();
        newPatient.setName(patient);

        var newDoctor = new Doctor();
        newDoctor.setName(doctor);

        projectServices.saveFeedback(newPatient, newDoctor, rating, comment);
        return "redirect:feedbackSuccess";
    }

    @GetMapping("/feedbackSuccess")
    public String showFeedbackSuccess(Model data) {
        data.addAttribute("feedback", projectServices.findAllFeedbacks().get(projectServices.findAllFeedbacks().size()-1));
        return "feedbackSuccess";
    }
}
