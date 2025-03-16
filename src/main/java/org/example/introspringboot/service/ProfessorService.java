package org.example.introspringboot.service;

import org.example.introspringboot.entity.Professor;


public interface ProfessorService {
    Professor findByNameIgnoreCase(String name);
}
