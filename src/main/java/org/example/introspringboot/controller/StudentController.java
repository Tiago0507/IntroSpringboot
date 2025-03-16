package org.example.introspringboot.controller;

import org.example.introspringboot.entity.Student;
import org.example.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    // @Qualifier solo se usa con interfaces
    public StudentController(@Qualifier("studentServiceImpl") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Student>> all() {
        var list = studentService.getByProgram("SIS");
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/all/{page}")
    @ResponseBody
    public ResponseEntity<Page<Student>> getStudents(@PathVariable int page) {
        var pageResponse = studentService.findAll(page);
        return ResponseEntity.status(200).body(pageResponse);
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Creando un estudiante: " + student.getName();
    }

    @GetMapping("/studentsofcourse")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudentsOfCourse() {
        var list = studentService.listStudentsOfCourse("Ingeniería de Software IV");
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/countbyprogram")
    @ResponseBody
    public ResponseEntity<Integer> getCountOfProgram() {
        int count = studentService.countStudentsByProgram("SIS");
        return ResponseEntity.status(200).body(count);
    }
}
