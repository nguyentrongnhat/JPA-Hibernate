package com.project.app.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String major;

    // TODO: Bidirectional One-to-One with Student

    public StudentProfile() {}
    public StudentProfile(String major) { this.major = major; }

    public Long getId() { return id; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
}
