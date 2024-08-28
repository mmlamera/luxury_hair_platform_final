package za.ac.cput.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceTest {
@Autowired
private InventoryService invService;
    Inventory inv;
    @BeforeEach
    void setUp(){inv = InventoryFactory.buildInventory("inv890","prod566",11299,"10 Dorset street,Woodstock","sup899",2000);}

    @Test
    @Order(1)
    void create() {
        Inventory inv1 = invService.create(inv);
        assertNotNull(inv1);
        System.out.println(inv1);
    }

    @Test
    @Order(2)
    void read() {
        Inventory read = invService.read(inv.getInventoryID());
        assertNotNull(read);
        System.out.println(read);

    }
    @Test
    @Order(3)
    void update() {
        Inventory updateInv = new Inventory.Builder().copy(inv).setQuantityAv(5000).build();
        Inventory update = invService.update(updateInv);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(invService.getall());
    }
}