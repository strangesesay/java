package com.example.studentsystem.Controller;

import com.example.studentsystem.Model.Course;
import com.example.studentsystem.Model.Student;
import com.example.studentsystem.Service.BusinessOperation;
import com.example.studentsystem.Service.CourseService;
import com.example.studentsystem.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService service;
    private final CourseService courseService;
    private final BusinessOperation businessOperation;

    public StudentController(StudentService service, CourseService courseService, BusinessOperation businessOperation) {
        this.service = service;
        this.courseService = courseService;
        this.businessOperation = businessOperation;
    }

    // Student endpoints
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updated) {
        return service.updateStudent(id, updated);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // Course endpoints
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Enrollment
    @PostMapping("/students/{studentId}/courses/{courseId}")
    public Student enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        return businessOperation.enrollStudentInCourse(studentId, courseId);
    }

}
