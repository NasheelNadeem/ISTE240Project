package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Appointment;
import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.AppointmentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {
    private final AppointmentServices appointmentService;

    public AppointmentController(AppointmentServices aptServ) {
        this.appointmentService = aptServ;
    }

    @GetMapping("/appointments")
    public String viewAppointment (Model data){
        data.addAttribute("appointments", appointmentService.findAllAppointments());
        return "appointments"; // appointments.mustache
    }

    @GetMapping("/addAppointment")
    public String addAppointmentForm(){
        // Since the requirement is a static page in the static folder
        return "redirect:/addAppointment.html";
    }

    @PostMapping("/addAppointment")
    public String addAppointment(
            @RequestParam("doctor") String doctorName,
            @RequestParam("patient") String patientName,
            @RequestParam("department") String department,
            @RequestParam("date") String date,
            @RequestParam("time") String time) {


        Appointment appointment = new Appointment();
        appointment.setDepartment(department);
        appointment.setDate(date);
        appointment.setTime(time);

        Patient p = new Patient();
        p.setName(patientName);
        appointment.setPatient(p);

        Doctor d = new Doctor();
        d.setName(doctorName);
        appointment.setDoctor(d);

        appointmentService.addAppointment(appointment);


        return "redirect:/add/success/appointment";
    }

    @GetMapping("/add/success/{entityName}")
    public String showSuccess(@PathVariable String entityName, Model data) {
        data.addAttribute("entity", entityName);

        var list = appointmentService.findAllAppointments();
        if (!list.isEmpty()) {
            data.addAttribute("recent", list.get(list.size() - 1));
        }
        return "success"; // success.mustache
    }
}