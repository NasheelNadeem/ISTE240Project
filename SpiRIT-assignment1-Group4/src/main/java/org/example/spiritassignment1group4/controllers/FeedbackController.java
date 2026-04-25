package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Feedback;
import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.FeedbackServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private FeedbackServices feedServ;

    public FeedbackController(FeedbackServices feedServ) {
        this.feedServ = feedServ;
    }

    @GetMapping
    public List<Feedback> viewFeedback() {
        return feedServ.findAllFeedbacks();
    }

    @PostMapping
    public Feedback addFeedback(@RequestParam String patient,
                                @RequestParam String doctor,
                                @RequestParam int rating,
                                @RequestParam String comment) {

        var newPatient = new Patient();
        newPatient.setName(patient);

        var newDoctor = new Doctor();
        newDoctor.setName(doctor);

        var feedback = new Feedback();
        feedback.setPatient(newPatient);
        feedback.setDoctor(newDoctor);
        feedback.setRating(rating);
        feedback.setComment(comment);

        return feedServ.saveFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedServ.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id,
                              @RequestParam String comment) {
        feedServ.updateComment(id, comment);
    }

    @GetMapping("/doctor")
    public List<Feedback> byDoctor(@RequestParam String name) {
        return feedServ.findByDoctor(name);
    }

    @GetMapping("/patient")
    public List<Feedback> byPatient(@RequestParam String name) {
        return feedServ.findByPatient(name);
    }

    @GetMapping("/rating")
    public List<Feedback> byRating(@RequestParam int rating) {
        return feedServ.findByRating(rating);
    }
}
