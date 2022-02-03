package com.medicare.Medicare.entity.medicare;

import com.medicare.Medicare.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany
    private List<Cart> carts;

    @OneToOne
    private User user;

    public Order() {
    }

    public Order(Long orderId, List<Cart> carts, User user) {
        this.orderId = orderId;
        this.carts = carts;
        this.user = user;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                '}';
    }
}
