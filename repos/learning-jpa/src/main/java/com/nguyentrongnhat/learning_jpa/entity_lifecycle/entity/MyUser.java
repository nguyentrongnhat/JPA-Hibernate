package com.nguyentrongnhat.learning_jpa.entity_lifecycle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "firstname")
    String firstName;

    @Column(name = "active")
    Boolean active;

    public MyUser(String lastName, String firstName, Boolean active) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.active = active;
    }
}
