package org.example.spiritassignment1group4.models;

import org.springframework.stereotype.Component;

@Component
public class Patient {
    private String name;
    private String patientID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientId(String patientID) {
        patientID = patientID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", PatientId='" + patientID + '\'' +
                '}';
    }
}
