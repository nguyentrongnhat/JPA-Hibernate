package com.nguyentrongnhat.learning_jpa.entity_relationship.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class Demo implements CommandLineRunner {

    private final OneToOneDemo oneToOneDemo;
    private final ManyToOneDemo manyToOneDemo;
    private final CascadingTechnique cascadingTechnique;
    private final ManyToManyDemo manyToManyDemo;

    @Override
    public void run(String... args) throws Exception {
        //Chạy Demo nào thì uncomment demo đó.
        //oneToOneDemo.runDemo();

        //manyToOneDemo.saveEntityDemo();
        //manyToOneDemo.bidirectionalDemo();

        cascadingTechnique.demoCascadeTypePersist();

        cascadingTechnique.demoCascadeTypeMerge();

        //cascadingTechnique.demoCascadeTypeRemove();

        manyToManyDemo.demoPersistData();
    }
}
