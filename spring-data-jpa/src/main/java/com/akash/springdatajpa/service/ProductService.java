package com.akash.springdatajpa.service;

import com.akash.springdatajpa.entity.Product;
import com.akash.springdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
@Autowired
    ProductRepository productRepository;
    public Product saveProduct(Product product){
        productRepository.save(product);
        return product;
    }
    public List<Product> saveProducts(List<Product> products){
        productRepository.saveAll(products);
        return products;
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public String deleteById(int id){
        productRepository.deleteById(id);
        return "Product with id "+id+" deleted...!!!";
    }
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
       return  productRepository.save(existingProduct);
    }
}
