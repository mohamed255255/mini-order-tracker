package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepository;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        orderRepository.saveAll(
            List.of(
                new Order("Order 1", 100.0, "Pending", 5),
                new Order("Order 2", 200.0, "Pending", 3),
                new Order("Order 3", 150.0, "Pending", 2)
        ));

    }
    
}
