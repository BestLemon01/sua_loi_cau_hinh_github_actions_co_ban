package com.quickbite.cart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final Map<String, List<String>> userCarts = new HashMap<>();

    @GetMapping("/{userId}")
    public ResponseEntity<List<String>> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(userCarts.getOrDefault(userId, Collections.emptyList()));
    }

    @PostMapping("/{userId}/items")
    public ResponseEntity<String> addItem(@PathVariable String userId, @RequestBody String item) {
        userCarts.computeIfAbsent(userId, k -> new ArrayList<>()).add(item);
        return ResponseEntity.ok("Item added to cart successfully");
    }
}
