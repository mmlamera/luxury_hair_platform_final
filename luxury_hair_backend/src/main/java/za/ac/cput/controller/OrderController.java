package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.services.OrderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("/read/{orderId}")
    public Order read(@PathVariable String orderId) {
        return orderService.read(orderId);
    }

    @GetMapping("/readall")
    public List<Order> readAll() {
        return orderService.getall();
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }
}