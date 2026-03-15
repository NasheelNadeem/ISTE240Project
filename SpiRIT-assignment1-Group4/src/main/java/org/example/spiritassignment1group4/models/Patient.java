package org.example.spiritassignment1group4.models;

public class Patient {
    private String name;
    private int patientID;

    public Patient(String name, int patientID) {
        this.name = name;
        this.patientID = patientID;
    }
    public Patient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientId(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", PatientId='" + patientID + '\'' +
                '}';
    }
}
