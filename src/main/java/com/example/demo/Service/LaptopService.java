package com.example.demo.Service;

import com.example.demo.Entity.Laptop;
import com.example.demo.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    // Create a new laptop
    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    // Retrieve a laptop by ID
    public Optional<Laptop> getLaptopById(String laptopId) {
        return laptopRepository.findById(laptopId);
    }

    // Retrieve all laptops
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    // Update a laptop
    public Laptop updateLaptop(String laptopId, Laptop updatedLaptop) {
        if (laptopRepository.existsById(laptopId)) {
            updatedLaptop.setID(laptopId);
            return laptopRepository.save(updatedLaptop);
        } else {
            // Handle not found or other appropriate error handling
            return null;
        }
    }

    // Delete a laptop by ID
    public void deleteLaptop(String laptopId) {
        laptopRepository.deleteById(laptopId);
    }
}