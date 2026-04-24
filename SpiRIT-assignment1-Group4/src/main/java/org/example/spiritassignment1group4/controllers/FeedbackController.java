package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Feedback;
import org.example.spiritassignment1group4.services.FeedbackServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackServices service;

    public FeedbackController(FeedbackServices service) {
        this.service = service;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return service.findAllFeedbacks();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return service.saveFeedback(feedback);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody String comment) {
        service.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/search/rating")
    public List<Feedback> byRating(@RequestParam int rating) {
        return service.findByRating(rating);
    }

    @GetMapping("/search/comment")
    public List<Feedback> byComment(@RequestParam String keyword) {
        return service.searchByComment(keyword);
    }

    @GetMapping("/search/doctor")
    public List<Feedback> byDoctor(@RequestParam String name) {
        return service.findByDoctor(name);
    }

    @GetMapping("/search/patient")
    public List<Feedback> byPatient(@RequestParam String name) {
        return service.findByPatient(name);
    }
}
