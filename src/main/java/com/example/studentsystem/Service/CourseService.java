package com.example.studentsystem.Service;

import com.example.studentsystem.Model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course createCourse(Course course);
    Optional<Course> getCourseById(Long id);
    List<Course> getAllCourses();
}
