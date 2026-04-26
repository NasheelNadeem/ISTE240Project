package org.example.spiritassignment1group4.repositories;

/*
 * Student Name: Ryan Benson
 * Student ID: 421007591
 */

import jakarta.transaction.Transactional;
import org.example.spiritassignment1group4.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    List<Patient> findAll();


    List<Patient> findByName(String name);

    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:name%")
    List<Patient> searchByNameCustom(@Param("name") String name);

    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    void updateNameById(@Param("id") Long id, @Param("name") String name);
}