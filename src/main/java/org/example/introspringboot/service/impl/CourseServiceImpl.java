package org.example.introspringboot.service.impl;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.repository.CourseRepository;
import org.example.introspringboot.repository.EnrollmentRepository;
import org.example.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        System.out.println("<<<< Get All Courses >>>>>");
        return courseRepository.findAll();
    }

    // Con base en lo que se va a obtener, ahí es donde se realiza el método
    @Override
    public List<Course> listCoursesOfStudent(long studentId) {
        var enrollments = enrollmentRepository.findByStudent_Id(studentId);
        return enrollments.stream().map(enrollment -> enrollment.getCourse()).toList();
    }

    @Override
    public Course getCourseById(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        /*Optional<Course> optCourse = courseRepository.findById(id);
        if (optCourse.isPresent()) {
            return optCourse.get();
        }else {
            throw new RuntimeException("Course not found with id: " + id);
        }*/
    }

    @Override
    public void deleteCourseById(long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }else {
            throw new RuntimeException("Course not found");
        }
    }

    @Override
    public List<Course> listCoursesOfProfessor(long professorId) {
        return courseRepository.findByProfessor_Id(professorId);
    }
}
