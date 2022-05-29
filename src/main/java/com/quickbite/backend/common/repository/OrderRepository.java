package com.quickbite.backend.common.repository;

import com.quickbite.backend.common.entity.Order;
import com.quickbite.backend.common.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
  List<Order> findOrdersByUser(User user);
  List<Order> findOrdersByUserAndStatus(User user, String status);
}