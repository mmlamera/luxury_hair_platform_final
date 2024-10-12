package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    void buildInventory() {
        Inventory inv = InventoryFactory.buildInventory("inv567","prod567",500, "10 Dorset Street Woodstock","supp789",600);
        assertNotNull(inv);
        System.out.println(inv);
    }
}