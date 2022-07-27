package com.project.backspring;

import com.project.backspring.model.Course;
import com.project.backspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackSpringApplication.class, args);
    }

    // SOMENTE A TITULO DE EXEMPLO

    // Por ser um CommandLineRunner, será chamado assim que a API é iniciada
    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular + Spring");
            c.setCategory("Front-end");

            courseRepository.save(c);
        };
    }
}
