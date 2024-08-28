package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    Product product;

    @BeforeEach
    void setUp() {

         product = ProductFactory.buildProduct("A6477", "Virgin", "Kinky curls",
                 "30 inches, 4x4 lace", "Ginger", true, 7000.00);
         assertNotNull(product);
        System.out.println(product);
    }


    @Test
    @Order(1)
    void create() {
        Product create = productService.create(product);
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    @Order(2)
    void read() {
        Product read = productService.read(product.getProductId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Product updateProduct = new Product.Builder().copy(product).setProductId("B8855").build();
        Product updated = productService.update(updateProduct);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(productService.getall());

    }
}