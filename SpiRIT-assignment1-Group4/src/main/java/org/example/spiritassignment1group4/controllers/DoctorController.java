// Nasheel Nadeem - 764000112
package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private DoctorService doctorservice;

    public DoctorController(DoctorService doctorservice) {
        this.doctorservice = doctorservice;
    }

    // GET all
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorservice.getAllDoctors();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorservice.getDoctorById(id).orElse(null);
    }

    // SEARCH
    @GetMapping("/search")
    public List<Doctor> searchDoctors(@RequestParam String name) {
        return doctorservice.searchByName(name);
    }

    // CREATE
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorservice.addDoctor(doctor);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorservice.updateDoctor(id, doctor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorservice.deleteDoctor(id);
    }


}