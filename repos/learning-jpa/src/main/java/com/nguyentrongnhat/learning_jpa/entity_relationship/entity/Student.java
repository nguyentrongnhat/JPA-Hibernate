package com.nguyentrongnhat.learning_jpa.entity_relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(
            name = "student_courses_re_name",
            joinColumns = @JoinColumn(name = "student_id_re_name"),
            inverseJoinColumns = @JoinColumn(name = "course_id_re_name")
    )
    private List<Course> courses;
}
