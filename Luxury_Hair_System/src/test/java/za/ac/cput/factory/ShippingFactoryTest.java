package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Shipping;

import static org.junit.jupiter.api.Assertions.*;

class ShippingFactoryTest {

    @Test
    void buildShipping() {
        Shipping shipping = ShippingFactory.buildShipping("shipment3455", "order346","Aramex", 90888,2000,"2024-03-12","2024-03-19","delivered");
        assertNotNull(shipping);
        System.out.println(shipping);
    }
}