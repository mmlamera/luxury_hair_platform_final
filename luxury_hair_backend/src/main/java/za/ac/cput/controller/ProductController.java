package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Product;
import za.ac.cput.services.ProductService;


import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(
            @RequestParam("hairTexture") String hairTexture,
            @RequestParam("hairStyle") String hairStyle,
            @RequestParam("hairSize") String hairSize,
            @RequestParam("hairColor") String hairColor,
            @RequestParam("hairStock") boolean hairStock,
            @RequestParam("hairPrice") double hairPrice,
            @RequestParam("image") MultipartFile image) throws IOException {

        Product product = service.createProduct( hairTexture,  hairStyle,  hairSize,
                 hairColor,  hairStock,  hairPrice,  image);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }


   /* @PostMapping("/create")
    public Product create(@RequestBody Product product){
        System.out.println("Product created!");
        return service.create(product);
    }*/

    @GetMapping("/read/{productId}")
    public Product read(@PathVariable Long productId){
        return service.read(productId);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product){
        return service.update(product);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getall());
    }


    //convert from blob to url so that it displays on frontend
    @GetMapping("/image/{productId}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long productId) {
        return service.getProductImageById(productId)
                .map(imageBytes -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") // Adjust MIME type as needed
                        .body(imageBytes))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}