package com.example.studentsystem.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


    @Entity
    @Table(name = "students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;
        private String email;

        @ManyToMany
        @JoinTable(
                name = "student_courses",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
        private Set<Course> courses = new HashSet<>();

        public Student() {
        }

        public Student(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        // getters & setters
        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Set<Course> getCourses() {
            return courses;
        }

        public void setCourses(Set<Course> courses) {
            this.courses = courses;
        }

    }

