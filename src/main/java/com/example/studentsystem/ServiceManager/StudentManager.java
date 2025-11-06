package com.example.studentsystem.ServiceManager;

import com.example.studentsystem.Model.Course;
import com.example.studentsystem.Model.Student;
import com.example.studentsystem.Repository.CourseRepo;
import com.example.studentsystem.Repository.StudentRepo;
import com.example.studentsystem.Service.BusinessOperation;
import com.example.studentsystem.Service.CourseService;
import com.example.studentsystem.Service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentManager implements StudentService, CourseService, BusinessOperation {

    private final StudentRepo studentRepository;
    private final CourseRepo courseRepository;

    public StudentManager(StudentRepo studentRepository, CourseRepo courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // --- Student ops ---
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student updated) {
        return studentRepository.findById(id)
                .map(s -> {
                    s.setFirstName(updated.getFirstName());
                    s.setLastName(updated.getLastName());
                    s.setEmail(updated.getEmail());
                    return studentRepository.save(s);
                }).orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // --- Course ops ---
    @Override
    public Course createCourse(Course course) {
        // prevent duplicate course code if needed
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // --- Business: enrollment ---
    @Override
    @Transactional
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found: " + courseId));

        student.getCourses().add(course);
        // course.getStudents().add(student);

        return studentRepository.save(student);
    }

}
