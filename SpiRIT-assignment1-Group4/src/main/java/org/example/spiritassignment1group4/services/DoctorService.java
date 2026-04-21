// Nasheel Nadeem - 764000112
package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorrepository;

    public DoctorService(DoctorRepository doctorrepository) {
        this.doctorrepository = doctorrepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorrepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorrepository.findById(id);
    }

    public List<Doctor> searchByName(String name) {
        return doctorrepository.findByName(name);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorrepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorrepository.findById(id).map(doc -> {
            doc.setName(updatedDoctor.getName());
            doc.setProfession(updatedDoctor.getProfession());
            return doctorrepository.save(doc);
        }).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorrepository.deleteById(id);
    }
}