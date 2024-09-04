package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    byte[] image = new byte[0];
    @Test
    void buildProductSuccess() {
        Product product = ProductFactory.buildProduct("Peruvian", "Bang", "10 inches",
                "Honey", true, 6000,  image);

        assertNotNull(product, "The product should be successfully created");
        assertEquals("Virgin", product.getHairTexture());
        assertEquals("Body wave curls", product.getHairStyle());
        assertEquals("24inches, 13x4 lace", product.getHairSize());
        assertEquals("Brown", product.getHairColor());
        assertTrue(product.isHairStock());
        assertEquals(3500.00, product.getHairPrice());
        assertArrayEquals(new byte[]{1, 2, 3}, product.getImage());

        System.out.println(product);
    }
}