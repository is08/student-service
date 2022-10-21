package com.example.tdd.studentservices.controller;

import com.example.tdd.studentservices.model.Student;
import com.example.tdd.studentservices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @GetMapping("/student/{id}/courses")
    //returns the courses for a specific student, not all the information
    //TODO: Add the scenario of Student not existing
    public ResponseEntity getAllCoursesForASpecificStudent(@PathVariable Integer id){
        return ResponseEntity.status(200).body(studentService.getAllCourses(id));
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity getSpecificCourseForASpecificStudent(@PathVariable Integer studentId, @PathVariable String courseId){
        System.out.println("here");

        try {
            System.out.println("here2");
            return ResponseEntity.status(200).body(studentService.getSpecificCourse(studentId, courseId));
        }
        catch (Exception e){
            System.out.println("here3");
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
