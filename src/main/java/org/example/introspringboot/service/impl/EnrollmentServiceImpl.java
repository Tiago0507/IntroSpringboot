package org.example.introspringboot.service.impl;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Enrollment;
import org.example.introspringboot.entity.Student;
import org.example.introspringboot.repository.EnrollmentRepository;
import org.example.introspringboot.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    @Transactional
    public void enrollStudent(long studentId, long courseId) {
        var course = new Course();
        course.setId(courseId);

        var student = new Student();
        student.setId(studentId);

        var enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);

        enrollmentRepository.save(enrollment);
    }

}
