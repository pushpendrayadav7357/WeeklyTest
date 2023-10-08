package com.example.demo.Controller;

import com.example.demo.Entity.Laptop;
import com.example.demo.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    // Create a new laptop
    @PostMapping
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

    // Retrieve a laptop by ID
    @GetMapping("/{laptopId}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable String laptopId) {
        Optional<Laptop> laptop = laptopService.getLaptopById(laptopId);
        return laptop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve all laptops
    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    // Update a laptop
    @PutMapping("/{laptopId}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable String laptopId, @RequestBody Laptop updatedLaptop) {
        Laptop updated = laptopService.updateLaptop(laptopId, updatedLaptop);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Delete a laptop by ID
    @DeleteMapping("/{laptopId}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable String laptopId) {
        laptopService.deleteLaptop(laptopId);
        return ResponseEntity.noContent().build();
    }
}
