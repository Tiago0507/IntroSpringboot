package org.example.introspringboot.service.impl;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Student;
import org.example.introspringboot.repository.EnrollmentRepository;
import org.example.introspringboot.repository.StudentRepository;
import org.example.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("<<<< Get All Students >>>>");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByProgram(String program) {
        return studentRepository.findByProgram(program);
    }

    @Override
    public Page<Student> findAll(int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> listStudentsOfCourse(String courseName) {
        var enrollments = enrollmentRepository.findByCourse_Name(courseName);
        return enrollments.stream().map(enrollment -> enrollment.getStudent()).toList();
    }

    @Override
    public int countStudentsByProgram(String program) {
        return studentRepository.countByProgram(program);
    }
}
