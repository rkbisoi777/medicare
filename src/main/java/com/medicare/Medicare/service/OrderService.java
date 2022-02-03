package com.medicare.Medicare.service;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.entity.medicare.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {
    public List<Order> getOrders();
    public List<Order> getUserOrders(User user);
    public Order createOrder(Long userId, List<Cart> carts);
}
