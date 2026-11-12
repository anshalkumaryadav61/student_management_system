package com.example.sms.service;

import com.example.sms.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student studentDetails);

    void deleteStudent(Long id);
}
