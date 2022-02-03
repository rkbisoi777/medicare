package com.medicare.Medicare.entity.dto;

import com.medicare.Medicare.entity.medicare.Product;
import com.sun.istack.NotNull;

public class CartItem {

    private Integer id;
    private @NotNull
    Product product;
    private @NotNull Integer quantity;

    public CartItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
