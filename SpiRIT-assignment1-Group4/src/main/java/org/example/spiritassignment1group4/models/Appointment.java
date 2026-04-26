//Mohammed Ahmad 754003903

package org.example.spiritassignment1group4.models;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department", length = 50, nullable = false)
    private String department;
    @Column(name = "date", length = 50, nullable = false)
    private String date;
    @Column(name = "time", length = 50, nullable = false)
    private String time;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Doctor doctor;


    public Appointment(String date, Long id, String department, String time, Patient patient, Doctor doctor) {
        this.date = date;
        this.id = id;
        this.department = department;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Appointment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
