package za.ac.cput.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.ShippingFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShippingServiceTest {
@Autowired
private ShippingService shippingService;
Shipping shipping;
 @BeforeEach
 void setUp(){shipping = ShippingFactory.buildShipping("shipment56","order4","PostNet",7866,800,"2023-12-06","2023-12-16","deliverd");}

    @Test
    @Order(1)
    void create() {
     Shipping shipment1 = shippingService.create(shipping);
     assertNotNull(shipment1);
        System.out.println(shipment1);
    }

    @Test
    @Order(2)
    void read() {
     Shipping read = shippingService.read(shipping.getShippingID());
     assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
     Shipping updateShipping = new Shipping.Builder().copy(shipping).setShippingCourier("Aramex").build();
     Shipping update = shippingService.update(updateShipping);
        System.out.println(update);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(shippingService.getall());
    }
}