package com.medicare.Medicare.service.impl;

import com.medicare.Medicare.entity.medicare.Category;
import com.medicare.Medicare.entity.medicare.Product;
import com.medicare.Medicare.repository.CategoryRepository;
import com.medicare.Medicare.repository.ProductRepository;
import com.medicare.Medicare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product addProduct(Product product, Long catId) throws Exception {
        Category category = this.categoryRepository.findById(catId).get();
        product.setCategory(category);
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long prodId, Product product) throws Exception {
        if(product != null){
            Optional<Product> prod = this.productRepository.findById(prodId);
            Product product1 = prod.get();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setQuantity(product.getQuantity());
            product1.setDescription(product.getDescription());
            product1.setCategory(product.getCategory());
            return product1;
        }else{
            System.out.println("Product Not Found");
            throw new Exception("Product Not Found");
        }
    }

    @Override
    public Product getProduct(Long prodId) {
        Optional<Product> product = this.productRepository.findById(prodId);
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> getProductsOfCategory(Category category) {
        return this.productRepository.findByCategory(category);
    }

    @Override
    public void deleteProduct(Long prodId) {
        this.productRepository.deleteById(prodId);
    }
}
