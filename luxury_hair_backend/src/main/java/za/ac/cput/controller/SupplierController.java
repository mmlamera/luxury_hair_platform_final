package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.ac.cput.domain.Supplier;
import za.ac.cput.services.ShippingService;
import za.ac.cput.services.SupplierService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create")
    public Supplier create(@RequestBody Supplier supplier){
        return supplierService.create(supplier);
    }

    @GetMapping("/read/{shippingId}")
    private Supplier read(@PathVariable String supplierId){
        return supplierService.read(supplierId);
    }

    @PostMapping("/update")
    private Supplier update(@RequestBody Supplier supplier){
        return supplierService.update(supplier);
    }

    @GetMapping("/getall")
    public Set<Supplier> getall() {
        return supplierService.getall().stream().collect(Collectors.toSet());
    }
}