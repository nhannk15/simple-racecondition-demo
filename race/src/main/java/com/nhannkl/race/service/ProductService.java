package com.nhannkl.race.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhannkl.race.model.entity.Order;
import com.nhannkl.race.model.entity.Product;
import com.nhannkl.race.repository.OrderRepository;
import com.nhannkl.race.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void buyProduct(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        // Product product = productRepository.findByIdWithPessimisticLock(productId).orElseThrow();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (product.getStock() < quantity) {
            System.out.println("Out of stock");
            return;
        }

        product.setStock(product.getStock() - quantity);
        Order newOrder = new Order(null, product);
        productRepository.save(product);
        orderRepository.save(newOrder);

        System.out.println("Success: bought" + quantity + " product");
    }

    @Transactional
    public void auctProduct(Long productId, BigDecimal price) {
        // Product product = productRepository.findById(productId).orElseThrow();
        Product product = productRepository.findByIdWithPessimisticLock(productId).orElseThrow();

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }

        product.setPrice(product.getPrice().add(price));
        productRepository.save(product);
        System.out.println("Auct: +" + price.floatValue());
    }

}
