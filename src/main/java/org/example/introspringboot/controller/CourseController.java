package org.example.introspringboot.controller;

import org.example.introspringboot.entity.Course;
import org.example.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Course course) {
        courseService.createCourse(course);
        return "Creando un curso: " + course.getName();
    }

    @GetMapping("/coursesofstudent")
    @ResponseBody
    public ResponseEntity<List<Course>> getCoursesOfStudent() {
        var list = courseService.listCoursesOfStudent(1);
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/coursesofprofessor")
    @ResponseBody
    public ResponseEntity<List<Course>> getCoursesOfProfessor() {
        var list = courseService.listCoursesOfProfessor(1);
        return ResponseEntity.status(200).body(list);
    }
}
