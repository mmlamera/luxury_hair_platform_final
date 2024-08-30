package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.HairServices;
import za.ac.cput.services.HairServicesService;

import java.util.List;

@RestController
@RequestMapping("/api/hairservices")
@CrossOrigin(origins = "http://localhost:5173")
public class HairServicesController {

    @Autowired
    private HairServicesService service;


    @PostMapping("/create")
    public ResponseEntity<HairServices> create(@RequestBody HairServices hairServices) {
        HairServices createdHairServices = service.create(hairServices);
        if (createdHairServices != null) {
            return ResponseEntity.ok(createdHairServices);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<HairServices> read(@PathVariable("id") Integer id) {
        HairServices hairServices = service.read(id);
        if (hairServices != null) {
            return ResponseEntity.ok(hairServices);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<HairServices> update(@RequestBody HairServices hairServices) {
        HairServices updatedHairServices = service.update(hairServices);
        if (updatedHairServices != null) {
            return ResponseEntity.ok(updatedHairServices);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/getall")
    public ResponseEntity<List<HairServices>> getall() {
        List<HairServices> allServices = service.getall();
        if (allServices != null && !allServices.isEmpty()) {
            return ResponseEntity.ok(allServices);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}