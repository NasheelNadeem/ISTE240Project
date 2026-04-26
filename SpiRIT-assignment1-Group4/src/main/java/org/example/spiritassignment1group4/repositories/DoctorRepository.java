package org.example.spiritassignment1group4.repositories;

import org.example.spiritassignment1group4.models.Doctor;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByName(String name);

    @Query("SELECT d FROM Doctor d WHERE d.profession = :profession")
    List<Doctor> findByProfessionCustom(@Param("profession") String profession);

    @Modifying
    @Query("UPDATE Doctor d SET d.profession = :profession WHERE d.id = :id")
    void updateProfessionById(@Param("id") Long id, @Param("profession") String profession);
}