//Mohammed Ahmad 754003903

package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Appointment;
import org.example.spiritassignment1group4.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentService;

    // GET /api/appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // GET /api/appointments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);

        if (appointment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(appointment.get());
    }

    // GET /api/appointments/search?department=Therapy
    // GET /api/appointments/search?department=Therapy&date=2026-04-20
    @GetMapping("/search")
    public List<Appointment> searchAppointmentsByDepartmentAndDate(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String date
    ) {
        if (department != null && date != null) {
            return appointmentService.findAppointmentsByDepartmentAndDate(department, date);
        }

        if (department != null) {
            return appointmentService.searchByDepartment(department);
        }

        return appointmentService.getAllAppointments();
    }

    // POST /api/appointments
    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    // PUT /api/appointments/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestBody Appointment updatedAppointment
    ) {
        Optional<Appointment> existingAppointment = appointmentService.getAppointmentById(id);

        if (existingAppointment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Appointment appointment = existingAppointment.get();

        appointment.setDepartment(updatedAppointment.getDepartment());
        appointment.setDate(updatedAppointment.getDate());
        appointment.setTime(updatedAppointment.getTime());
        appointment.setPatient(updatedAppointment.getPatient());
        appointment.setDoctor(updatedAppointment.getDoctor());

        Appointment savedAppointment = appointmentService.saveAppointment(appointment);

        return ResponseEntity.ok(savedAppointment);
    }

    // PATCH /api/appointments/{id}/department
    @PatchMapping("/{id}/department")
    public ResponseEntity<String> updateAppointmentDepartment(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String department = body.get("department");

        if (department == null || department.isBlank()) {
            return ResponseEntity.badRequest().body("Department is required.");
        }

        Optional<Appointment> existingAppointment = appointmentService.getAppointmentById(id);

        if (existingAppointment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        appointmentService.updateAppointmentDepartmentById(id, department);

        return ResponseEntity.ok("Appointment department updated successfully.");
    }

    // DELETE /api/appointments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        Optional<Appointment> existingAppointment = appointmentService.getAppointmentById(id);

        if (existingAppointment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        appointmentService.deleteAppointment(id);

        return ResponseEntity.ok("Appointment deleted successfully.");
    }
}