package com.medicare.Medicare.controller;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.entity.medicare.Order;
import com.medicare.Medicare.service.OrderService;
import com.medicare.Medicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    //create order
    @PostMapping("/{userId}")
    public Order createOrder(@PathVariable Long userId, @RequestBody List<Cart> carts){
        return this.orderService.createOrder(userId,carts);
    }

    //get all orders
    @GetMapping("/")
    public List<Order> getAllOrders(){
        return this.orderService.getOrders();
    }

    //get user orders
    @GetMapping("/{username}")
    public List<Order> getUserOrders(@PathVariable String username){
        User user = this.userService.getUser(username);
        return this.orderService.getUserOrders(user);
    }
}
