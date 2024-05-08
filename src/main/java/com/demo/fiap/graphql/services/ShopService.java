package com.demo.fiap.graphql.services;

import com.demo.fiap.graphql.entities.Product;
import com.demo.fiap.graphql.entities.Shop;
import com.demo.fiap.graphql.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository repo;

    ShopService(
            ShopRepository repository
    ) {
        this.repo = repository;
    }

    public Shop findById(Long id) {
        return this.repo.findById(id).orElse(null);
    }

    public List<Shop> findAll() {
        return this.repo.findAll();
    }

    public Shop save(Shop shop) {
        return this.repo.save(shop);
    }

    public Long deleteById(Long id) {
        this.repo.deleteById(id);
        return id;
    }
}
