package com.nhannkl.race.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhannkl.race.service.ProductService;

@RestController 
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/buy/{id}")
    public ResponseEntity<String> buy(@PathVariable Long id, @RequestParam int quantity) {
        productService.buyProduct(id, quantity);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/auction/{id}")
    public ResponseEntity<String> auct(@PathVariable Long id, @RequestParam BigDecimal price) {
        productService.auctProduct(id, price);
        return ResponseEntity.ok("Thank you for you braveness");

        //--- 10_000 + 10_000 * 100 = 1010_000
        //--- There will still be more requests with different prices for the auction...
    }

}
