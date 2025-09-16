package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@Tag(name = "Orders", description = "CRUD related to orders")

public class OrderController {
       
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    
    @GetMapping("/getOrders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "You expected to see order found"),
            @ApiResponse(responseCode = "404", description = "You expected to see Order not found")
        })    
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    @Parameter(description=" this is the order id")
    public  ResponseEntity<Map<String, Object>>  getOrderById(@PathVariable Long id) {
        return this.orderService.getOrderById(id);
    }


    @PostMapping("storeOrder")
    public ResponseEntity<String> storeOrder(@RequestBody Order order) {
         return this.orderService.storeOrder(order);        
    }


    @PutMapping("updateOrder/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order order) {
      return this.orderService.updateOrder(id, order);
    }
    
    @PatchMapping("updateOrderStatus/{id}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int id, @RequestBody Order order) {
      return this.orderService.updateOrderStatus(id, order);
    }


}
