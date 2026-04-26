package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.FeedbackServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {
    private FeedbackServices feedServ;

    public FeedbackController(FeedbackServices feedServ) {
        this.feedServ = feedServ;
    }

    @GetMapping("/feedbacks")
    public String viewFeedback(Model data) {
        data.addAttribute("feedbacks", feedServ.findAllFeedbacks());
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

        feedServ.saveFeedback(newPatient, newDoctor, rating, comment);
        return "redirect:feedbackSuccess";
    }

    @GetMapping("/feedbackSuccess")
    public String showFeedbackSuccess(Model data) {
        data.addAttribute("feedback", feedServ.findAllFeedbacks().get(feedServ.findAllFeedbacks().size()-1));
        return "feedbackSuccess";
    }
}
