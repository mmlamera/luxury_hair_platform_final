package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventoryRepositoryTest {
@Autowired
private InventoryRepository repository;
private Inventory inv;
    @BeforeEach
    void setUp() {
        inv = InventoryFactory.buildInventory("inv7899","prod5666",800,"10 Mokando Street Khayelitsha","sup8900",5000);
        assertNotNull(inv);
        System.out.println(inv);
    }
}