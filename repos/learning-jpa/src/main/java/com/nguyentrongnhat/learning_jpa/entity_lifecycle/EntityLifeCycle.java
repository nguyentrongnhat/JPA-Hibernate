package com.nguyentrongnhat.learning_jpa.entity_lifecycle;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
public class EntityLifeCycle implements CommandLineRunner {

    private final PersistingEntity persistEntity;

    @Override
    public void run(String... args) throws Exception {
        this.persistEntity.TestPersistEntity();
    }
}
