package com.array.onlineshopspring.repository;

import com.array.onlineshopspring.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Integer> {
}
