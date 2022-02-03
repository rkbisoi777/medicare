package com.medicare.Medicare.service;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.entity.dto.CartItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public interface CartService {
    public List<Cart> getCart(User user);
    public CartItem addProduct(CartItem cartItem, User user);
    public CartItem removeProduct(CartItem cartItem, User user);
//    public List<Product> getAllProducts(Long cartId);
    public AtomicReference<Double> getTotal(User user);
}
