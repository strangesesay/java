package com.example.studentsystem.Service;

import com.example.studentsystem.Model.Student;

public interface BusinessOperation {
    Student enrollStudentInCourse(Long studentId, Long courseId);
}
