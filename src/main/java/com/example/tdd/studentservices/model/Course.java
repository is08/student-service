package com.example.tdd.studentservices.model;

import com.example.tdd.studentservices.repository.StudentRepository;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "steps")
    private String steps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Course(){
    }

    public Course(String id, String name, String description, String steps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", steps=" + steps +
                '}';
    }
}
