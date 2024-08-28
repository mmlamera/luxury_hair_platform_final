package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierService  implements ISupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    SupplierService(SupplierRepository productRepository) {
        this.supplierRepository = supplierRepository;
    }

    private SupplierService() {

    }

    @Override
    public Set<Supplier> getall() {
        return supplierRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier read(String productId) {
        return supplierRepository.findById(productId).orElse(null);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepository.save(supplier);
    }


}
