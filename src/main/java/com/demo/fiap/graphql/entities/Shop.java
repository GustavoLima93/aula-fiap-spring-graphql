package com.demo.fiap.graphql.entities;

import jakarta.persistence.*;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "client_id", nullable = true)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "product_id", nullable = true)
    private Product product;


    public Shop(Long id, Integer quantity, String status, Client client, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.client = client;
        this.product = product;
    }

    public Shop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

