package org.example.spiritassignment1group4.models;

import org.springframework.stereotype.Component;

@Component
public class Doctor {
    private String name;
    private int doctorID;
    private String profession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", doctorID='" + doctorID + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
