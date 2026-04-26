//Mohammed Ahmad 754003903

package org.example.spiritassignment1group4.repositories;

import jakarta.transaction.Transactional;
import org.example.spiritassignment1group4.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findByDepartment(String department);

    @Query("SELECT a FROM Appointment a WHERE a.department = :department AND a.date = :date")
    List<Appointment> findByDepartmentAndDate(String department, String date);


    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Appointment a SET a.department = :department WHERE a.id = :id")
    void updateDepartmentById(Long id, String department);

}
