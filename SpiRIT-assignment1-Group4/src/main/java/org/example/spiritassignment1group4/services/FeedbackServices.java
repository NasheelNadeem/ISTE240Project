package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Feedback;
import org.example.spiritassignment1group4.models.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServices {
    List<Feedback> feedbacks = new ArrayList<>();

    public FeedbackServices() {
        var p1 = new Patient();
        p1.setName("Mark House");
        p1.setPatientId(11);

        var d1 = new Doctor();
        d1.setName("Habil Gray");
        d1.setDoctorID(55);

        var f1 = new Feedback();
        f1.setPatient(p1);
        f1.setDoctor(d1);
        f1.setRating(5);
        f1.setComment("Very helpful session.");

        feedbacks.add(f1);

        var p2 = new Patient();
        p2.setName("John Jalp");
        p2.setPatientId(12);

        var d2 = new Doctor();
        d2.setName("Pasor Serical");
        d2.setDoctorID(52);

        var f2 = new Feedback();
        f2.setPatient(p2);
        f2.setDoctor(d2);
        f2.setRating(4);
        f2.setComment("Good support and advice.");

        feedbacks.add(f2);
    }

    public List<Feedback> findAllFeedbacks() {
        return this.feedbacks;
    }

    public void saveFeedback(Patient patient, Doctor doctor, int rating, String comment) {
        var newFeedback = new Feedback();
        newFeedback.setPatient(patient);
        newFeedback.setDoctor(doctor);
        newFeedback.setRating(rating);
        newFeedback.setComment(comment);
        this.feedbacks.add(newFeedback);
    }
}
