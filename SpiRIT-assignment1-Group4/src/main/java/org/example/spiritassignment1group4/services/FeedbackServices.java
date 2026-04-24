package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.Feedback;
import org.example.spiritassignment1group4.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackServices {

    private final FeedbackRepository repo;

    public FeedbackServices(FeedbackRepository repo) {
        this.repo = repo;
    }

    public List<Feedback> findAllFeedbacks() {
        return repo.findAll();
    }

    public Feedback findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return repo.save(feedback);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public List<Feedback> findByRating(int rating) {
        return repo.findByRating(rating);
    }

    public List<Feedback> searchByComment(String keyword) {
        return repo.findByCommentContaining(keyword);
    }

    public List<Feedback> findByDoctor(String name) {
        return repo.findByDoctorName(name);
    }

    public List<Feedback> findByPatient(String name) {
        return repo.findByPatientName(name);
    }

    public void updateComment(Long id, String comment) {
        repo.updateCommentById(id, comment);
    }
}
