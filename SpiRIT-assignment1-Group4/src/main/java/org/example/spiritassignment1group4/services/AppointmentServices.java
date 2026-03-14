package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.Appointment;
import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Patient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServices {
    List<Appointment> appointments = new ArrayList<>();

    public AppointmentServices(){
        var p1 = new Patient();
        p1.setName("Mark House");
        p1.setPatientId(11);
        var d1 = new Doctor();
        d1.setName("Habil Gray");
        d1.setDoctorID(55);

        var a1 = new Appointment();
        a1.setPatient(p1);
        a1.setDoctor(d1);
        a1.setDepartment("Therapy");
        a1.setDate("03/11/2026");
        a1.setTime("11:30AM");

        appointments.add(a1);

        var p2 = new Patient();
        p2.setName("John Jalp");
        p2.setPatientId(12);
        var d2 = new Doctor();
        d2.setName("Pasor Serical");
        d2.setDoctorID(52);

        var a2 = new Appointment();
        a2.setPatient(p2);
        a2.setDoctor(d2);
        a2.setDepartment("Psycho");
        a2.setDate("05/11/2026");
        a2.setTime("12:30PM");

        appointments.add(a2);
    }


    public List<Appointment> findAllAppointments () {
        return this.appointments;
    }

    public void saveAppointment(Patient patient, Doctor doctor, String department, String date, String time){
        var newAppointment = new Appointment();
        newAppointment.setPatient(patient);
        newAppointment.setDoctor(doctor);
        newAppointment.setDepartment(department);
        newAppointment.setDate(date);
        newAppointment.setTime(time);
        this.appointments.add(newAppointment);
    }

}
