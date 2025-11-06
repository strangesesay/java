package com.example.studentsystem.Repository;

import com.example.studentsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
