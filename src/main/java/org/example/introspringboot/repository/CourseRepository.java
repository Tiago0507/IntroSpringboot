package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // List<Course> findByStudent(Student student);
    // Page<Student> findByCourse(Course course, Pageable pageable);
    List<Course> findByProfessor_Id(Long professorId);

}
