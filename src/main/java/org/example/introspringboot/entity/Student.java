package org.example.introspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.List;

// POJOs
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String code;

    private String program;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Enrollment> enrollments;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) { this.code = code; }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }


}
