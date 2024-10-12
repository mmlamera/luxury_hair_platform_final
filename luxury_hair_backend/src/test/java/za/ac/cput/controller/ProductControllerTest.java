package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/LuxuryHairVendingSystemDB/product";
    private static Product product;
    byte[] image = new byte[0];

    @BeforeEach
    @Test
    public void setUp() {

        product = ProductFactory.buildProduct( "Peruvian", "Straight", "30inches, 13x4 lace", "Hazel Brown", true, 5600.00, image);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Product> response = restTemplate.postForEntity(url, product, Product.class);

        assertNotNull(response);
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertNotNull(response.getBody());

        System.out.println("Created Product: " + response.getBody());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/" + product.getProductId();
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        assertNotNull(response.getBody());
        System.out.println("Read Product: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Product updatedProduct = new Product.Builder().copy(product).setHairTexture("Brazilian").build();
        ResponseEntity<Product> response = restTemplate.postForEntity(url, updatedProduct, Product.class);
        assertNotNull(response);
        System.out.println("Updated Product: " + response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/" + product.getProductId();
        restTemplate.delete(url);
        System.out.println("Deleted Product with ID: " + product.getProductId());
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All Products: " + responseEntity.getBody());
    }
}