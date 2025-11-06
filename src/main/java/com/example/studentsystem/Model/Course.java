package com.example.studentsystem.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "courses")
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String code;   // e.g., CS101
        private String title;

        @ManyToMany(mappedBy = "courses")
        private Set<Student> students = new HashSet<>();

        public Course() {
        }

        public Course(String code, String title) {
            this.code = code;
            this.title = title;
        }

        // getters & setters
        public Long getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Set<Student> getStudents() {
            return students;
        }

        public void setStudents(Set<Student> students) {
            this.students = students;
        }
    }

