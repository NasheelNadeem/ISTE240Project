package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServices {

    private final List<Appointment> appointments = new ArrayList<>();
    private final List<UserAccount> userAccounts = new ArrayList<>();
    private final List<Feedback> feedbacks = new ArrayList<>();
    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();

    public ProjectServices() {
        var p1 = new Patient();
        p1.setName("Mark House");
        p1.setPatientId(11);

        var p2 = new Patient();
        p2.setName("John Jalp");
        p2.setPatientId(12);

        var p3 = new Patient();
        p3.setName("Sarah Smith");
        p3.setPatientId(13);

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);

        Doctor d1 = new Doctor();
        d1.setName("Habil Gray");
        d1.setId(55L);
        d1.setProfession("Psychologist");

        Doctor d2 = new Doctor();
        d2.setName("Pasor Serical");
        d2.setId(52L);
        d2.setProfession("Therapist");

        doctors.add(d1);
        doctors.add(d2);

        var a1 = new Appointment();
        a1.setPatient(p1);
        a1.setDoctor(d1);
        a1.setDepartment("Therapy");
        a1.setDate("2026-03-11");
        a1.setTime("11:30");
        appointments.add(a1);

        var u1 = new UserAccount();
        u1.setUserName("mark11");
        u1.setPassword("mark123");
        u1.setRole("Patient");
        userAccounts.add(u1);

        var f1 = new Feedback();
        f1.setPatient(p1);
        f1.setDoctor(d1);
        f1.setRating(5);
        f1.setComment("Very helpful session.");
        feedbacks.add(f1);
    }

    public List<Patient> findAllPatients() {
        return this.patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public List<Doctor> findAllDoctors() {
        return this.doctors;
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public List<Appointment> findAllAppointments() {
        return this.appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public List<UserAccount> findAllUserAccounts() {
        return this.userAccounts;
    }

    public void saveUserAccount(String userName, String password, String role) {
        var newUserAccount = new UserAccount();
        newUserAccount.setUserName(userName);
        newUserAccount.setPassword(password);
        newUserAccount.setRole(role);
        this.userAccounts.add(newUserAccount);
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