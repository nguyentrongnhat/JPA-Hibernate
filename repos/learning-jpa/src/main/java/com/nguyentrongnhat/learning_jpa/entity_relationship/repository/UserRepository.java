package com.nguyentrongnhat.learning_jpa.entity_relationship.repository;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
