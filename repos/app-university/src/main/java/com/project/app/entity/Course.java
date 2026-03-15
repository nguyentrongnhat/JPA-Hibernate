package com.project.app.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    // TODO: Many-to-One with Instructor
    // TODO: Many-to-Many with Students via Enrollment

    public Course() {}
    public Course(String title) { this.title = title; }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
