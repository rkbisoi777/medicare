package com.medicare.Medicare.entity.medicare;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicare.Medicare.entity.User;

import javax.persistence.*;

@Entity
@Table(name="carts")
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long cartId;

    @ManyToOne
    private Product products;

    @ManyToOne
    @JsonIgnore
    private User user;

    private int quantity;

    public Cart() {
    }

    public Cart(Long cartId, Product products, User user) {
        this.cartId = cartId;
        this.products = products;
        this.user = user;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
