package org.example.spiritassignment1group4;

import org.example.spiritassignment1group4.models.*;
import org.example.spiritassignment1group4.repositories.FeedbackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpiRitAssignment1Group4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpiRitAssignment1Group4Application.class, args);
    }

    @Bean
    CommandLineRunner seed(FeedbackRepository repo){
        return args -> {

            Feedback f = new Feedback();

            Patient p = new Patient();
            p.setName("Mark");

            Doctor d = new Doctor();
            d.setName("Habil");

            f.setPatient(p);
            f.setDoctor(d);
            f.setRating(5);
            f.setComment("Great service");

            repo.save(f);
        };
    }
}
