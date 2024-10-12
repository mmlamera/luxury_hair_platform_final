package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Newsletter;
import za.ac.cput.services.NewsletterService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/newsletter")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsletterController {
    @Autowired
    private NewsletterService service;
    @PostMapping("/create")
    public Newsletter createUser(@RequestBody Newsletter request) {
        return service.create(request);
    }
    @GetMapping("/email-exists")
    public ResponseEntity<Map<String, Boolean>> checkEmailExists(@RequestParam String email) {
        boolean exists = service.checkEmailExists(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
}