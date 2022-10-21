package com.example.tdd.studentservices.repository;

import com.example.tdd.studentservices.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
