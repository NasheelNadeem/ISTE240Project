package org.example.spiritassignment1group4.models;

import jakarta.persistence.*;

import java.util.List;

//Nasheel Nadeem 764000112
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "profession", length = 50, nullable = true)
    private String profession;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks;

    public Doctor() {}

    public Doctor(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public void setId(Long id) {
        this.id = id; // IMPORTANT (fixes update)
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}