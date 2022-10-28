package com.example.tdd.studentservices.controller;

import com.example.tdd.studentservices.model.Course;
import com.example.tdd.studentservices.model.Student;
import com.example.tdd.studentservices.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = StudentController.class)
@AutoConfigureMockMvc
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnAllTheStudentsAndTheirRespectiveCourses() throws Exception{
        List<Student> allStudents = List.of();

        when(studentService.getAll()).thenReturn(null);

        this.mvc.perform(get("/student"))
                        .andExpect(status().is2xxSuccessful());

        verify(studentService, times(1)).getAll();
    }

}
