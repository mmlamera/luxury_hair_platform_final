package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;
    private Product product;
    byte[] image = new byte[0];


    @BeforeEach
    void setUp() {

        product = ProductFactory.buildProduct("Brazilian", "Bob", "14 inches",
                "Brown", true, 4500, image);
        assertNotNull(product, "Product should not be null after creation");


        product = repository.save(product);
        assertNotNull(product.getProductId(), "Product ID should be generated after saving");
        System.out.println(product);
    }

    @Test
    void findProductByProductId() {

        Product foundProduct = repository.findProductByProductId(21L);

        // Assert that the product was found and has the expected attributes
        assertNotNull(foundProduct, "Product should be found");
        assertEquals(product.getProductId(), foundProduct.getProductId(), "Product ID should match");
        assertEquals(product.getHairTexture(), foundProduct.getHairTexture(), "Hair texture should match");
        assertEquals(product.getHairStyle(), foundProduct.getHairStyle(), "Hair style should match");
        assertEquals(product.getHairSize(), foundProduct.getHairSize(), "Hair size should match");
        assertEquals(product.getHairColor(), foundProduct.getHairColor(), "Hair color should match");
        assertEquals(product.isHairStock(), foundProduct.isHairStock(), "Hair stock status should match");
        assertEquals(product.getHairPrice(), foundProduct.getHairPrice(), "Hair price should match");

        System.out.println(foundProduct);
    }
}
