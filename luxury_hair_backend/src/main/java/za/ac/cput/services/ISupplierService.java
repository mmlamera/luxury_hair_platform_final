package za.ac.cput.services;

import za.ac.cput.domain.Supplier;

import java.util.Set;

public interface ISupplierService {
    Set<Supplier> getall();

    Supplier create(Supplier supplier);

    Supplier read(String productId);

    Supplier update(Supplier supplier);
}
