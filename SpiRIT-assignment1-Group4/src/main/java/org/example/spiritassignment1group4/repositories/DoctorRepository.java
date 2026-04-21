// Nasheel Nadeem - 764000112
package org.example.spiritassignment1group4.repositories;

import org.example.spiritassignment1group4.models.Doctor;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Find by field
    List<Doctor> findByName(String name);

    // Custom query (JPQL)
    @Query("SELECT d FROM Doctor d WHERE d.profession = :profession")
    List<Doctor> findByProfessionCustom(@Param("profession") String profession);

    // Update query
    @Modifying
    @Transactional
    @Query("UPDATE Doctor d SET d.profession = :profession WHERE d.id = :id")
    void updateProfessionById(@Param("id") Long id, @Param("profession") String profession);


}