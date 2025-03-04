package org.example.introspringboot.service;

import org.example.introspringboot.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    void createStudent(Student student);
    List<Student> getAllStudents();
}
