package org.example.spiritassignment1group4.services;

import org.example.spiritassignment1group4.models.Doctor;
import org.example.spiritassignment1group4.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Nasheel Nadeem 764000112
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> searchByName(String name) {
        return doctorRepository.findByName(name);
    }

    public List<Doctor> searchByProfession(String profession) {
        return doctorRepository.findByProfession(profession);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id).map(doc -> {
            doc.setName(updatedDoctor.getName());
            doc.setProfession(updatedDoctor.getProfession());
            return doctorRepository.save(doc);
        }).orElse(null);
    }

    public boolean deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            return false;
        }
        doctorRepository.deleteById(id);
        return true;
    }

    public boolean updateProfession(Long id, String profession) {
        return doctorRepository.updateProfessionById(id, profession) > 0;
    }
}