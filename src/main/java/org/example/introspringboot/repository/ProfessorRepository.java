package org.example.introspringboot.repository;

import org.example.introspringboot.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByNameIgnoreCase(String name);
}
