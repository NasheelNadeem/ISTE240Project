package org.example.spiritassignment1group4.models;

import jakarta.persistence.*;

// Mohamed Ahmed 767000238
@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating", length = 10, nullable = false)
    private int rating;
    @Column(name = "comment", length = 255, nullable = true)
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Doctor doctor;

    public Feedback(Long id, Patient patient, Doctor doctor, int rating, String comment) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.rating = rating;
        this.comment = comment;
    }

    public Feedback() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
