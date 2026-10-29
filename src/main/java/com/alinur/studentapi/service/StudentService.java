package com.alinur.studentapi.service;

import com.alinur.studentapi.exception.StudentNotFoundException;
import com.alinur.studentapi.model.Student;
import com.alinur.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setStudentIdNumber(studentDetails.getStudentIdNumber());
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setMajor(studentDetails.getMajor());
        student.setGPA(studentDetails.getGPA());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.delete(student);
    }

    @Transactional(readOnly = true)
    public List<Student> searchStudents(String query) {
        return studentRepository.findByMajorContainingIgnoreCaseOrLastNameContainingIgnoreCase(query, query);
    }

    @Transactional(readOnly = true)
    public List<Student> getHonorRollStudents(Double minGpa) {
        return studentRepository.findByGpaGreaterThanEqualOrderByGpaDesc(minGpa != null ? minGpa : 3.5);
    }
}
