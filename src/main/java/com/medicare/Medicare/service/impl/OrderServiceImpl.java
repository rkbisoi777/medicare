package com.medicare.Medicare.service.impl;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.entity.medicare.Order;
import com.medicare.Medicare.repository.OrderRepository;
import com.medicare.Medicare.repository.UserRepository;
import com.medicare.Medicare.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return this.orderRepository.findByUser(user);
    }

    @Override
    public Order createOrder(Long userId, List<Cart> carts) {
        User user = this.userRepository.findById(userId).get();
        Order newOrder = new Order();
        newOrder.setCarts(carts);
        newOrder.setUser(user);
        return this.orderRepository.save(newOrder);
    }
}
