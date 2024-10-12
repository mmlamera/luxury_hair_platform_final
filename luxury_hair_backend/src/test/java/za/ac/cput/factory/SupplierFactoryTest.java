package za.ac.cput.factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import javax.lang.model.element.Name;

import static org.junit.jupiter.api.Assertions.*;


public class SupplierFactoryTest {
    @Test
    void buildSupplier(){
        Supplier supplier = SupplierFactory.buildSupplier( "2332", "Weave Releave", "0766002342", "weavereleave@gmail.com", "Cheque", "DD weaves");
        assertNotNull(supplier);
        System.out.println(supplier);
    }
}
