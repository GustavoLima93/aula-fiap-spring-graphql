package com.demo.fiap.graphql.controllers;

import com.demo.fiap.graphql.dtos.ProductDTO;
import com.demo.fiap.graphql.entities.Product;
import com.demo.fiap.graphql.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService service;

    ProductController(
            ProductService service
    ) {
        this.service = service;
    }

    @QueryMapping
    public Product product(@Argument Long id) {
        return  this.service.findById(id);
    }

    @QueryMapping
    public List<Product> products() {
        return this.service.findAll();
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductDTO productDTO) {
        ModelMapper model = new ModelMapper();
        Product product = model.map(productDTO, Product.class);
        return this.service.save(product);
    }

    @MutationMapping
    public Long deleteProduct(@Argument Long id) {
        return this.service.deleteById(id);
    }
}
