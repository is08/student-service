package com.example.tdd.studentservices.repository;

import com.example.tdd.studentservices.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
