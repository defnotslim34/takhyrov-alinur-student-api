package com.alinur.studentapi;

import com.alinur.studentapi.model.Student;
import com.alinur.studentapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                // Seed primary author student data
                Student alinur = new Student(
                        "38110",
                        "Alinur",
                        "Takhyrov",
                        "defnotslim34@student.kz",
                        "DevOps & Cloud Engineering",
                        3.95
                );
                repository.save(alinur);

                // Seed additional classmate sample data
                Student sample = new Student(
                        "38111",
                        "Arman",
                        "Kassymov",
                        "arman.k@student.kz",
                        "Software Engineering",
                        3.70
                );
                repository.save(sample);
            }
        };
    }
}
