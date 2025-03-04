package org.example.introspringboot.controller;

import org.example.introspringboot.entity.Student;
import org.example.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    // @Qualifier solo se usa con interfaces
    public StudentController(@Qualifier("studentServiceImpl") StudentService studentService) {
        this.studentService = studentService;
    }

    /*@Autowired
    @Qualifier
    private StudentService studentService;*/


    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Student>> all() {
        var list = studentService.getAllStudents();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Creando un estudiante " + student.getName();
    }
}
