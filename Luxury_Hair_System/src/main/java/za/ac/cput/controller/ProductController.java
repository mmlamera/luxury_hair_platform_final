package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.api.ProductApi;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.services.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        System.out.println("Entered create");
        return service.create(product);
    }

    @GetMapping("/read/{productId}")
    public Product read(@PathVariable String productId){
        return service.read(productId);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product){
        return service.update(product);
    }

    @GetMapping("/getall")
    public List<Product> getall(){
        return service.getall();
    }

}
