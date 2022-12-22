package com.akash.springdatajpa.controller;

import com.akash.springdatajpa.entity.Product;
import com.akash.springdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/get")
    public List<Product> getAllProduct(){
        return service.getAllProduct();
    }
    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @PostMapping("/post")
    public Product createProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/posts")
    public List<Product> createProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    @PutMapping("/put")
    public Product updateProduct (@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProductById (@PathVariable int id){
        return service.deleteById(id);
    }
}