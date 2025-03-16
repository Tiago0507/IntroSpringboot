package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByProgram(String Program);
    Page<Student> findAll(Pageable pageable);
    int countByProgram(String program);

    /*@Query(value = "SELECT s.id,s.name,s.code,s.program FROM students s JOIN enrollments e ON s.id = e.student_id JOIN courses c ON e.course_id=c.id WHERE c.id = :courseId", nativeQuery = true)
    List<Student> findStudentsInCourse(long courseId);*/

}
