package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Appointment;
import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.models.Patient;
import org.example.spiritassignment1group4.services.AppointmentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppointmentController {
    private AppointmentServices aptServ;

    public AppointmentController(AppointmentServices aptServ) {
        this.aptServ = aptServ;
    }

    @GetMapping("/appointments")
    public String viewAppointment (Model data){
        data.addAttribute("appointments", aptServ.findAllAppointments());
        return "appointments";
    }

    @GetMapping("/addAppointment")
    public String addAppointmentForm(Model data){
        return "redirect:addAppointment.html";
    }

    @PostMapping("/addAppointment")
    public String addAppointment(@RequestParam Patient patient, @RequestParam Doctor doctor, @RequestParam String department, @RequestParam String date, @RequestParam String time, Model data){
        aptServ.saveAppointment(patient, doctor, department, date, time);
        return "redirect:success";
    }

    @GetMapping("/success") // [cite: 60, 61]
    public String showSuccess(Model data) {
        // Inject the entity name into the confirmation message template [cite: 62]
        data.addAttribute(aptServ.findAllAppointments().get(aptServ.findAllAppointments().size()-1));
        return "success";
    }




}
