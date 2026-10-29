package com.alinur.studentapi.controller;

import com.alinur.studentapi.model.Student;
import com.alinur.studentapi.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("GET /api/students/info returns student Alinur Takhyrov metadata")
    void testGetDeveloperInfo() throws Exception {
        mockMvc.perform(get("/api/students/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Alinur Takhyrov"))
                .andExpect(jsonPath("$.studentId").value("38110"))
                .andExpect(jsonPath("$.github").value("defnotslim34"))
                .andExpect(jsonPath("$.project").value("takhyrov-alinur-student-api"));
    }

    @Test
    @DisplayName("GET /api/students retrieves list containing Alinur Takhyrov")
    void testGetAllStudents() throws Exception {
        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$[0].firstName").value("Alinur"))
                .andExpect(jsonPath("$[0].lastName").value("Takhyrov"));
    }

    @Test
    @DisplayName("POST /api/students creates a new student successfully")
    void testCreateStudent() throws Exception {
        String studentJson = """
                {
                    "studentIdNumber": "38199",
                    "firstName": "Damir",
                    "lastName": "Ospanov",
                    "email": "damir.ospanov@student.kz",
                    "major": "Cybersecurity",
                    "gpa": 3.85
                }
                """;

        mockMvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Damir"))
                .andExpect(jsonPath("$.lastName").value("Ospanov"))
                .andExpect(jsonPath("$.studentIdNumber").value("38199"));
    }

    @Test
    @DisplayName("GET /api/students/99999 returns 404 for nonexistent student")
    void testGetNonexistentStudentReturns404() throws Exception {
        mockMvc.perform(get("/api/students/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.author").value("Alinur Takhyrov (ID: 38110)"));
    }
}
