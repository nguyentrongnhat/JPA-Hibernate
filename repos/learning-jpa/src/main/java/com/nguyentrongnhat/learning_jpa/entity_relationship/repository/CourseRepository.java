package com.nguyentrongnhat.learning_jpa.entity_relationship.repository;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
