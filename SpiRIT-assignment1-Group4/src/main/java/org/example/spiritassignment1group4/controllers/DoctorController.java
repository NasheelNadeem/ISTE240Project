package org.example.spiritassignment1group4.controllers;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Nasheel Nadeem 764000112
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Doctor> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String profession
    ) {
        if (name != null) {
            return doctorService.searchByName(name);
        }
        if (profession != null) {
            return doctorService.searchByProfession(profession);
        }
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctor doctor
    ) {
        Doctor updated = doctorService.updateDoctor(id, doctor);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        if (!doctorService.deleteDoctor(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    @PatchMapping("/{id}/profession")
    public ResponseEntity<String> updateProfession(
            @PathVariable Long id,
            @RequestBody String profession
    ) {
        if (!doctorService.updateProfession(id, profession)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Profession updated");
    }
}