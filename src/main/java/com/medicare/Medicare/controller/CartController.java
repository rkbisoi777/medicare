package com.medicare.Medicare.controller;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.entity.dto.CartItem;
import com.medicare.Medicare.repository.UserRepository;
import com.medicare.Medicare.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    public CartService cartService;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId){
        Optional<User> userOptional = this.userRepository.findById(userId);
        User user = userOptional.get();
        return this.cartService.getCart(user);
    }

    @PostMapping("/add/{userId}")
    public CartItem addItem(@PathVariable Long userId, @RequestBody CartItem cartItem){
        Optional<User> userOptional = this.userRepository.findById(userId);
        User user = userOptional.get();
        this.cartService.addProduct(cartItem,user);
        return cartItem;
    }

    @PostMapping("/remove/{userId}")
    public void removeItem(@PathVariable Long userId, @RequestBody CartItem cartItem){
        Optional<User> userOptional = this.userRepository.findById(userId);
        User user = userOptional.get();
        this.cartService.removeProduct(cartItem, user);
    }

    @GetMapping("/total/{userId}")
    public AtomicReference<Double> getTotal(@PathVariable Long userId){
        Optional<User> userOptional = this.userRepository.findById(userId);
        User user = userOptional.get();
        return this.cartService.getTotal(user);
    }

//    @GetMapping("/allproducts/{cartId}")
//    public List<Product> getAllProducts(@PathVariable Long cartId){
//        return this.cartService.getAllProducts(cartId);
//    }
}
