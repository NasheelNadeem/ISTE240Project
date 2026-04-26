package org.example.spiritassignment1group4.repositories;

import jakarta.transaction.Transactional;
import org.example.spiritassignment1group4.models.Doctor;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Nasheel Nadeem 764000112
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByName(String name);

    @Query("SELECT d FROM Doctor d WHERE d.profession = :profession")
    List<Doctor> findByProfession(@Param("profession") String profession);

    @Modifying
    @Transactional
    @Query("UPDATE Doctor d SET d.profession = :profession WHERE d.id = :id")
    int updateProfessionById(@Param("id") Long id, @Param("profession") String profession);
}