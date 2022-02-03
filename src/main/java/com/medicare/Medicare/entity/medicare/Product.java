package com.medicare.Medicare.entity.medicare;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prodId;
    private String name;
    private double price;
    private int quantity;
    @Column(length = 5000)
    private String description;
    private String picture;
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(Long prodId, String name, double price, int quantity, String description, String picture, Category category) {
        this.prodId = prodId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.picture = picture;
        this.category = category;

    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", category=" + category +
                '}';
    }
}
