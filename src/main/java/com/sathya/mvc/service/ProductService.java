package com.sathya.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.mvc.model.Product;
import com.sathya.mvc.repository.ProductRepository;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    public boolean createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        if (savedProduct != null) {
            logger.info("Product created successfully: {}", savedProduct);
            return true;
        } else {
            logger.error("Failed to create product");
            return false;
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        logger.info("Retrieved all products in service layer and returned to controller layer: {}", products);
        return products;
    }

    public Product getProduct(Long proId) {
        Product product = productRepository.findById(proId).orElse(null);
        if (product != null) {
            logger.info("Retrieved product by ID {}: {}", proId, product);
        } else {
            logger.warn("Product with ID {} not found", proId);
        }
        return product;
    }

    public void deleteProduct(Long proId) {
        productRepository.deleteById(proId);
        logger.info("Deleted product with ID: {}", proId);
    }

}
