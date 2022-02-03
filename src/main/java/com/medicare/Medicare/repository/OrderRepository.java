package com.medicare.Medicare.repository;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Order;
import com.medicare.Medicare.entity.medicare.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByUser(User user);
}
