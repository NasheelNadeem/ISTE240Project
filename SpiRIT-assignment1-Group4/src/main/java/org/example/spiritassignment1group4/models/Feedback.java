package org.example.spiritassignment1group4.models;

import org.springframework.stereotype.Component;

@Component
public class Feedback {

    private Patient patient;
    private Doctor doctor;
    private int rating;
    private String comment;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
