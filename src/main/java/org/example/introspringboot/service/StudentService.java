package org.example.introspringboot.service;

import org.example.introspringboot.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getByProgram(String program);
    Page<Student> findAll(int page);
    List<Student> listStudentsOfCourse(String courseName);
    int countStudentsByProgram(String program);
}
