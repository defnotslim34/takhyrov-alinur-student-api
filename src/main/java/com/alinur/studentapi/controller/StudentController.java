package com.alinur.studentapi.controller;

import com.alinur.studentapi.model.Student;
import com.alinur.studentapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @Value("${app.author.name:Alinur Takhyrov}")
    private String authorName;

    @Value("${app.author.student-id:38110}")
    private String authorStudentId;

    @Value("${app.author.github:defnotslim34}")
    private String authorGithub;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student created = studentService.createStudent(student);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Student successfully deleted");
        response.put("id", id);
        response.put("deletedBy", authorName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam(defaultValue = "") String query) {
        return ResponseEntity.ok(studentService.searchStudents(query));
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getDeveloperInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("studentName", authorName);
        info.put("studentId", authorStudentId);
        info.put("github", authorGithub);
        info.put("project", "takhyrov-alinur-student-api");
        info.put("version", "1.0.0");
        info.put("timestamp", LocalDateTime.now());
        info.put("status", "ACTIVE");
        return ResponseEntity.ok(info);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "takhyrov-alinur-student-api");
        health.put("maintainedBy", authorName + " (" + authorStudentId + ")");
        health.put("timestamp", LocalDateTime.now());
        return ResponseEntity.ok(health);
    }
}
