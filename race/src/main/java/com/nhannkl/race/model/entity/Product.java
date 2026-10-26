package com.nhannkl.race.model.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "tbl_products")
public class Product {
    
    @Id 
    private Long id;

    @Column 
    private String name;

    @Column 
    private int stock;

    @Column 
    private BigDecimal price;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Order> orders;

    public Product() {
    }

    

    public Product(Long id, String name, int stock, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    

}
