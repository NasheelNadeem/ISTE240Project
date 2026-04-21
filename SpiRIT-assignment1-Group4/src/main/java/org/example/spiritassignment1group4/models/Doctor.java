// Nasheel Nadeem - 764000112
package org.example.spiritassignment1group4.models;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}