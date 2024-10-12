package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.ShippingFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShippingRepositoryTest {
@Autowired
private ShippingRepository repo;
private Shipping shipping;

    @BeforeEach
    void setUp() {
        shipping = ShippingFactory.buildShipping("shipment677","order588","Aramex",7896,600,"2024-04-10","2024-04-20","procesing");
        assertNotNull(shipping);
        System.out.println(shipping);
    }
}