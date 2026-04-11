package com.nguyentrongnhat.learning_jpa.entity_relationship.demo;

import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.OrderEntity;
import com.nguyentrongnhat.learning_jpa.entity_relationship.entity.UserEntity;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.OrderRepository;
import com.nguyentrongnhat.learning_jpa.entity_relationship.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CascadingTechnique {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void demoCascadeTypePersist() {
        var user1 = new UserEntity();

        var order1 = new OrderEntity();

        var order2 = new OrderEntity();

        order1.setUser(user1);

        order2.setUser(user1);

        orderRepository.saveAll(List.of(order1, order2));
    }

    public void demoCascadeTypeMerge() {
        var user = userRepository.findById(1L).get();
        var orders = orderRepository.findAll();

        user.setName("Edited Name");

        for (OrderEntity order : orders) {
            order.setOrderName("OrderName edited");
        }

        user.setOrders(orders);

        userRepository.save(user);
    }

    public void demoCascadeTypeRemove() {
        var user = userRepository.findById(1L).get();
        userRepository.delete(user);
    }


}
