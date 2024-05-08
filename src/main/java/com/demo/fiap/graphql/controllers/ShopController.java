package com.demo.fiap.graphql.controllers;

import com.demo.fiap.graphql.dtos.ShopDTO;
import com.demo.fiap.graphql.entities.Shop;
import com.demo.fiap.graphql.services.ClientService;
import com.demo.fiap.graphql.services.ProductService;
import com.demo.fiap.graphql.services.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShopController {

    private final ShopService service;
    private final ProductService productService;
    private final ClientService clientService;

    ShopController(
            ShopService service,
            ProductService productService,
            ClientService clientService) {
        this.service = service;
        this.productService = productService;
        this.clientService = clientService;
    }

    @QueryMapping
    public Shop purchase(@Argument Long id) {
        return  this.service.findById(id);
    }

    @QueryMapping
    public List<Shop> purchases() {
        return this.service.findAll();
    }

    @MutationMapping
    public Shop savePurchase(@Argument ShopDTO shopDTO) {
        ModelMapper model = new ModelMapper();
        Shop shop = model.map(shopDTO, Shop.class);
        shop.setProduct(this.productService.findById(shopDTO.getProductId()));
        shop.setClient(this.clientService.findById(shopDTO.getClientId()));
        return this.service.save(shop);
    }

    @MutationMapping
    public Long deletePurchase(@Argument Long id) {
        return this.service.deleteById(id);
    }
}
