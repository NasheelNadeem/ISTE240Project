//Mohammed Ahmad 754003903

package org.example.spiritassignment1group4.services;

import jakarta.transaction.Transactional;
import org.example.spiritassignment1group4.models.Appointment;
import org.example.spiritassignment1group4.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AppointmentServices {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> searchByDepartment(String department) {
        return appointmentRepository.findByDepartment(department);
    }

    public List<Appointment> findAppointmentsByDepartmentAndDate(String department, String date) {
        return appointmentRepository.findByDepartmentAndDate(department, date);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void updateAppointmentDepartmentById(Long id, String department) {
        appointmentRepository.updateDepartmentById(id, department);
    }

}
