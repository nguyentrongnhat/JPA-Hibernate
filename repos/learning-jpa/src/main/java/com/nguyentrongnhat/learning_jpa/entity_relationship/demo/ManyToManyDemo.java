package com.nguyentrongnhat.learning_jpa.entity_relationship.demo;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Course;
import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Student;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.CourseRepository;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManyToManyDemo {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void demoPersistData() {
        var student1 = new Student(null, "Nguyen Van A", null);
        var student2 = new Student(null, "Tran Van B", null);

        var course1 = new Course(null, "Math", null);
        var course2 = new Course(null, "English", null);
        var course3 = new Course(null, "Literature", null);
        var course4 = new Course(null, "History", null);
        var course5 = new Course(null, "Physics", null);

        //this.courseRepository.saveAll(List.of(course1, course2, course3, course4, course5));

        student1.setCourses(List.of(course1, course2));

        student2.setCourses(List.of(course3, course4, course5));

        this.studentRepository.saveAll(List.of(student1, student2));
    }
}
