package com.nguyentrongnhat.learning_jpa.entity_lifecycle;

import com.nguyentrongnhat.learning_jpa.entity_lifecycle.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PersistingEntity {
    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    public void TestPersistEntity() {
        MyUser firstUser = new MyUser("Nhat", "Nguyen", true);

        var afterMerge = entityManager.merge(firstUser);
        afterMerge.setFirstName("Updated First name");
        entityManager.flush();
        afterMerge.setActive(false);
        entityManager.refresh(afterMerge);
        log.info(String.valueOf(afterMerge.getActive()));


    }
}
