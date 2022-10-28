package com.example.tdd.studentservices.controller;

import com.example.tdd.studentservices.model.Course;
import com.example.tdd.studentservices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "/student", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @GetMapping(value = "/student/{id}/courses")
    //returns the courses for a specific student, not all the information
    //TODO: Add the scenario of Student not existing
    public ResponseEntity getAllCoursesForASpecificStudent(@PathVariable Integer id){
        return ResponseEntity.status(200).body(studentService.getAllCourses(id));
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity getSpecificCourseForASpecificStudent(@PathVariable Integer studentId, @PathVariable String courseId){
        try {
            return ResponseEntity.status(200).body(studentService.getSpecificCourse(studentId, courseId));
        }
        catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity addSpecificCourseForASpecificStudent(@PathVariable Integer studentId, @PathVariable String courseId){
        try {
            studentService.addCourse(studentId, courseId);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
        return ResponseEntity.status(200).build();
    }

}
