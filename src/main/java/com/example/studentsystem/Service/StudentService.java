package com.example.studentsystem.Service;

import com.example.studentsystem.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {


    //Student Operations

    Student createStudent(Student student);
    Optional<Student> getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student updated);
    void deleteStudent(Long id);




}
