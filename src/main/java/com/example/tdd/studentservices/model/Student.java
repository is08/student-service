package com.example.tdd.studentservices.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "enrolled_courses")
    @ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER)
    @NotNull
    private List<Course> enrolledCourses;

    public Student(){}

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, List<Course> enrolledCourses){
        this.id = id;
        this.name = name;
        this.enrolledCourses = enrolledCourses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
