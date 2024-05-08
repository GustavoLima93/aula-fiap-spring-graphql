package com.demo.fiap.graphql.dtos;

public class ShopDTO {

    private Long id;

    private Integer quantity;

    private String status;


    private Long clientId;


    private Long productId;


    public ShopDTO(Long id, Integer quantity, String status, Long clientId, Long productId) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.clientId = clientId;
        this.productId = productId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
