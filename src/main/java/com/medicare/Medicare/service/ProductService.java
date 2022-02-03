package com.medicare.Medicare.service;

import com.medicare.Medicare.entity.medicare.Category;
import com.medicare.Medicare.entity.medicare.Product;

import java.util.List;

public interface ProductService {

    //add product
    public Product addProduct(Product product, Long catId) throws Exception;

    //update product
    public Product updateProduct(Long prodId, Product product) throws Exception;

    //get product
    public Product getProduct(Long prodId);

    //get all products
    public List<Product> getAllProducts();

    //get products of category
    public List<Product> getProductsOfCategory(Category category);

    //delete product
    public void deleteProduct(Long prodId);
}
