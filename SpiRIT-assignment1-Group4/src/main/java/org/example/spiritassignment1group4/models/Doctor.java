package org.example.spiritassignment1group4.models;

import jakarta.persistence.*;

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