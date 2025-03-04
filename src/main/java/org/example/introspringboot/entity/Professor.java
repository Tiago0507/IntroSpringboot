package org.example.introspringboot.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "professor") //Nombre de la propiedad en la otra clase
    private List<Course> courseList;

    //ToDo: Hacer Getters y Setters

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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
