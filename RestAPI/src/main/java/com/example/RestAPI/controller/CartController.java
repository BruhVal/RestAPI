package com.example.RestAPI.controller;

import com.example.RestAPI.model.CartItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cart")
public class CartController {
    private List<CartItem> cart = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<CartItem> viewCart() {
        return cart;
    }

    @PostMapping
    public CartItem addItem(@RequestBody CartItem item) {
        item.setId(counter.incrementAndGet());
        cart.add(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable Long id) {
        cart.removeIf(item -> item.getId().equals(id));
    }
}
