package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent_Id(long id);
    List<Enrollment> findByCourse_Name(String courseName);
}
