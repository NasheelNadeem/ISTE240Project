package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Feedback;
import org.example.spiritassignment1group4.services.FeedbackServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Mohamed Ahmed 767000238
@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackServices feedServ;

    public FeedbackController(FeedbackServices feedServ) {
        this.feedServ = feedServ;
    }

    // GET /api/feedbacks
    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedServ.getAllFeedbacks();
    }

    // GET /api/feedbacks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedServ.getFeedbackById(id);

        if (feedback.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(feedback.get());
    }

    // POST /api/feedbacks
    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedServ.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    // PUT /api/feedbacks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @PathVariable Long id,
            @RequestBody Feedback updatedFeedback
    ) {
        Optional<Feedback> existingFeedback = feedServ.getFeedbackById(id);

        if (existingFeedback.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Feedback feedback = existingFeedback.get();

        feedback.setPatient(updatedFeedback.getPatient());
        feedback.setDoctor(updatedFeedback.getDoctor());
        feedback.setRating(updatedFeedback.getRating());
        feedback.setComment(updatedFeedback.getComment());

        Feedback savedFeedback = feedServ.saveFeedback(feedback);

        return ResponseEntity.ok(savedFeedback);
    }

    // DELETE /api/feedbacks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        Optional<Feedback> existingFeedback = feedServ.getFeedbackById(id);

        if (existingFeedback.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        feedServ.deleteFeedback(id);

        return ResponseEntity.ok("Feedback deleted successfully.");
    }

    // GET /api/feedbacks/search/doctor?name=xxx
    @GetMapping("/search/doctor")
    public List<Feedback> searchByDoctor(@RequestParam String name) {
        return feedServ.findByDoctorName(name);
    }

    // GET /api/feedbacks/search/patient?name=xxx
    @GetMapping("/search/patient")
    public List<Feedback> searchByPatient(@RequestParam String name) {
        return feedServ.findByPatientName(name);
    }

    // GET /api/feedbacks/search/rating?rating=5
    @GetMapping("/search/rating")
    public List<Feedback> searchByRating(@RequestParam int rating) {
        return feedServ.findByRating(rating);
    }

    // GET /api/feedbacks/search/comment?keyword=xxx
    @GetMapping("/search/comment")
    public List<Feedback> searchByComment(@RequestParam String keyword) {
        return feedServ.findByCommentContaining(keyword);
    }
}
