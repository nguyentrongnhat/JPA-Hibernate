package com.nguyentrongnhat.learning_jpa.entity_relationship.repository;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
