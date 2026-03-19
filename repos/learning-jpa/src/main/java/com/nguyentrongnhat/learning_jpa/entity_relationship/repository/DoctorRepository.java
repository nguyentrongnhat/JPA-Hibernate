package com.nguyentrongnhat.learning_jpa.entity_relationship.repository;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d FROM Doctor d JOIN FETCH d.patients WHERE d.id = :id")
    Optional<Doctor> finDoctorByIdWithPatients(Long id);
}
