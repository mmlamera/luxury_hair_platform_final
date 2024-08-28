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


    @BeforeEach
    void setUp() {
        product = ProductFactory.buildProduct("A6477", "Brazillian", "Bob",
                "30 inches, 4x4 lace", "Ginger", true, 7000.00);
        assertNotNull(product);
        System.out.println(product);
    }
    @Test
    void findProductByProductId() {
        product = repository.findProductByProductId("A6477");
        System.out.println(product);
    }
}