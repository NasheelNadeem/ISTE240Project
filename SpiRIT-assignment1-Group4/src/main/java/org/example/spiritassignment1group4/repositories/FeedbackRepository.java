package org.example.spiritassignment1group4.repositories;

import org.example.spiritassignment1group4.models.Feedback;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByRating(int rating);

    List<Feedback> findByCommentContaining(String keyword);

    @Query("SELECT f FROM Feedback f WHERE f.doctor.name = :name")
    List<Feedback> findByDoctorName(@Param("name") String name);

    @Query("SELECT f FROM Feedback f WHERE f.patient.name = :name")
    List<Feedback> findByPatientName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Feedback f SET f.comment = :comment WHERE f.id = :id")
    void updateCommentById(@Param("id") Long id, @Param("comment") String comment);
}
