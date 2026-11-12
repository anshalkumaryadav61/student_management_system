package com.example.sms.controller;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    private StudentService studentService;

    @Test
    void shouldCreateAndFetchStudent() {
        Student student = new Student();
        student.setFirstName("Alice");
        student.setLastName("Johnson");
        student.setEmail("alice@example.com");
        student.setAge(20);

        Student savedStudent = studentService.saveStudent(student);

        assertThat(savedStudent.getId()).isNotNull();
        assertThat(studentService.getStudentById(savedStudent.getId()).getEmail())
                .isEqualTo("alice@example.com");
        assertThat(studentService.getAllStudents()).isNotEmpty();
    }
}