// Mohamed Ahmed 767000238

package org.example.spiritassignment1group4.services;

import jakarta.transaction.Transactional;
import org.example.spiritassignment1group4.models.Feedback;
import org.example.spiritassignment1group4.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeedbackServices {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public List<Feedback> findByRating(int rating) {
        return feedbackRepository.findByRating(rating);
    }

    public List<Feedback> findByCommentContaining(String keyword) {
        return feedbackRepository.findByCommentContaining(keyword);
    }

    public List<Feedback> findByDoctorName(String name) {
        return feedbackRepository.findByDoctorName(name);
    }

    public List<Feedback> findByPatientName(String name) {
        return feedbackRepository.findByPatientName(name);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    public void updateCommentById(Long id, String comment) {
        feedbackRepository.updateCommentById(id, comment);
    }
}
