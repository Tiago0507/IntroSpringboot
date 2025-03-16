package org.example.introspringboot.service;

import org.example.introspringboot.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    List<Course> listCoursesOfStudent(long studentId);
    Course getCourseById(long id);
    void deleteCourseById(long id);
    List<Course> listCoursesOfProfessor(long professorId);
}
