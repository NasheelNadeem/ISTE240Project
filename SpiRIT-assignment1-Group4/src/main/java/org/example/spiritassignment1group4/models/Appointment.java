package org.example.data;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.Time;

@Component
public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String department;
    private Data date;
    private Time time;

    public Appointment(Patient patient, Doctor doctor, String department, Data date, Time time) {
        this.patient = patient;
        this.doctor = doctor;
        this.department = department;
        this.date = date;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", department='" + department + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
