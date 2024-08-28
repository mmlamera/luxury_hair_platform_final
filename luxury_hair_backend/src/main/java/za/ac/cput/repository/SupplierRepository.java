package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Supplier;

@Repository

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    Supplier findBySupplierID(String supplierID);

}
