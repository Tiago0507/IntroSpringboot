package org.example.introspringboot.controller;

import org.example.introspringboot.entity.Professor;
import org.example.introspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/searchbyname")
    @ResponseBody
    public ResponseEntity<Professor> searchByName() {
        Professor professor = professorService.findByNameIgnoreCase("gabriel tamura");
        return ResponseEntity.status(200).body(professor);
    }
}
