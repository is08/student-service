package com.example.tdd.studentservices.service;

import com.example.tdd.studentservices.model.Course;
import com.example.tdd.studentservices.model.Student;
import com.example.tdd.studentservices.repository.CourseRepository;
import com.example.tdd.studentservices.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public List<Course> getAllCourses(Integer id) {
        return studentRepository.findById(id).get().getEnrolledCourses();
    }

    //TODO: Poor logic, please improve
    public Course getSpecificCourse(Integer studentId, String courseId) {
        System.out.println("here4");
        List<Course> courses= studentRepository.findById(studentId).get().getEnrolledCourses();
        boolean isFound = false;
        Course tempCourse = new Course();

        for(Course course: courses){
            if(course.getId() == courseId){
                isFound = true;
                tempCourse = course;
            }
        }

        if(isFound == true){
            System.out.println(tempCourse);
            return tempCourse;
        }
        return null;
    }
}
