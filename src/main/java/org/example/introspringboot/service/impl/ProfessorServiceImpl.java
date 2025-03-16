package org.example.introspringboot.service.impl;

import org.example.introspringboot.entity.Professor;
import org.example.introspringboot.repository.ProfessorRepository;
import org.example.introspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor findByNameIgnoreCase(String name) {
        return professorRepository.findByNameIgnoreCase(name);
    }
}
