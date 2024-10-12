package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.ac.cput.domain.Cart;
import za.ac.cput.services.CartService;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart){
        System.out.println("Cart created!");
        return service.create(cart);
    }

    @GetMapping("/read/{cartId}")
    public Cart read(@PathVariable Long cartId){
        return service.read(cartId);
    }

    @PostMapping("/update")
    public Cart update(@RequestBody Cart cart){
        return service.update(cart);
    }

    @GetMapping("/getall")
    public List<Cart> getall(){
        return service.getall();
    }

}