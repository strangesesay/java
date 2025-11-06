package com.example.studentsystem.Repository;

import com.example.studentsystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);
}
