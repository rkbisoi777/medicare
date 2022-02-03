package com.medicare.Medicare.controller;

import com.medicare.Medicare.entity.medicare.Category;
import com.medicare.Medicare.entity.medicare.Product;
import com.medicare.Medicare.service.CategoryService;
import com.medicare.Medicare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/{catId}")
    public Product addProduct(@RequestBody Product product,@PathVariable Long catId) throws Exception {
        return this.productService.addProduct(product,catId);
    }

    @GetMapping("/{prodId}")
    public Product getProduct(@PathVariable Long prodId){
        return this.productService.getProduct(prodId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/category/{catId}")
    public List<Product> getProductsOfCategory(@PathVariable String catId){
        Long catIdnew = Long.parseLong(catId);
        Category category = this.categoryService.getCategory(catIdnew);
        return this.productService.getProductsOfCategory(category);
    }

    @PutMapping("/{prodId}")
    public Product updateProduct(@PathVariable Long prodId, @RequestBody Product product) throws Exception {
        return this.productService.updateProduct(prodId,product);
    }

    @DeleteMapping("/{prodId}")
    public void deleteProduct(@PathVariable Long prodId){
        this.productService.deleteProduct(prodId);
    }
}
