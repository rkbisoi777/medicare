package com.medicare.Medicare.service.impl;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.entity.dto.CartItem;
import com.medicare.Medicare.entity.medicare.Product;
import com.medicare.Medicare.repository.CartRepository;
import com.medicare.Medicare.repository.UserRepository;
import com.medicare.Medicare.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Cart> getCart(User user) {
        return this.cartRepository.findAllByUser(user);
    }

    @Override
    public CartItem addProduct(CartItem cartItem, User user) {
        Product product = cartItem.getProduct();
        List<Cart> carts = this.cartRepository.findAllByUser(user);
        if(carts.size() != 0){
            System.out.println("Adding Quantity");
            carts.forEach((c)->{
                c.setQuantity(c.getQuantity() + cartItem.getQuantity());
                cartRepository.save(c);
            });
        }else{
            System.out.println("Adding Product Not Quantity");
            Cart cart = new Cart();
            cart.setProducts(product);
            cart.setUser(user);
            cart.setQuantity(cartItem.getQuantity());
            cartRepository.save(cart);
        }
        return cartItem;
    }

    @Override
    public CartItem removeProduct(CartItem cartItem, User user) {
        Product product = cartItem.getProduct();
        List<Cart> carts = this.cartRepository.findAllByUser(user);
        carts.forEach((c)->{
            c.setQuantity(c.getQuantity() - 1);
            cartRepository.save(c);
        });
        return cartItem;
    }

    @Override
    public AtomicReference<Double> getTotal(User user) {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        List<Cart> carts = this.cartRepository.findAllByUser(user);
        carts.forEach((c)->{
            total.set(+c.getProducts().getPrice()*c.getQuantity());
            System.out.println(total);
        });
        return total;
    }


//    @Override
//    public List<Product> getAllProducts(Long cartId) {
//        Cart cart = this.cartRepository.findById(cartId).get();
//        return cart.getProducts();
//    }

}
