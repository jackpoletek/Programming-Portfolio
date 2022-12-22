package com.array.onlineshopspring.repository;

import com.array.onlineshopspring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
//    List<OrderItem> findAll(Sort sort);
}
