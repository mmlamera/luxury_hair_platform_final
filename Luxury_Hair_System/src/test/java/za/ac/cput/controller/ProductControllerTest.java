package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/product";

    private static Product product;


    @BeforeEach
    @Order(1)
   public void setUp() {
        product = ProductFactory.buildProduct("H3322", "Peruvian", "Straight",
               "30inches, 13x4 lace", "Hazel Brown", true, 5600.00);
    }

    @Test
    @Order(2)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
       // assertEquals(postResponse.getStatusCode(), HttpStatus.OK);

        Product productSaved = postResponse.getBody();
        assertEquals(product.getProductId(), productSaved.getProductId());
        System.out.println("Saved data: " + productSaved);
    }

    @Test
    @Order(3)
    void read() {
        String productId = "H3322";
        String url = BASE_URL + "/getall" +productId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.GET, entity, Product.class);

        System.out.println("Show ALL products : " + productId);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }


    @Test
    @Order(4)
    void update() {
        String url = BASE_URL + "/update";
        Product newProduct = new Product.Builder().copy(product).setHairTexture("Yaki").build();
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, newProduct, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Product updated = postResponse.getBody();
        assertEquals(newProduct.getProductId(), updated.getProductId());
        System.out.println("Updated data: " + updated);
    }

    @Test
    @Order(5)
    void getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }



   /* @Test
    void delete() {
        String url = BASE_URL + "/delete/" + product.getProductId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success deleted product");
    } */
}