package com.demo.fiap.graphql.services;

import com.demo.fiap.graphql.entities.Product;
import com.demo.fiap.graphql.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    ProductService(
            ProductRepository repository
    ) {
        this.repo = repository;
    }

    public Product findById(Long id) {
        return this.repo.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return this.repo.findAll();
    }

    public Product save(Product product) {
        return this.repo.save(product);
    }

    public Long deleteById(Long id) {
        this.repo.deleteById(id);
        return id;
    }
}
