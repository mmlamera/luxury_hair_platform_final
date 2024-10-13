package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.UserLogin;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ProductRepository; // Assuming you have this repository
import za.ac.cput.repository.UserLoginRepository; // Assuming you have this repository
import org.springframework.http.HttpMethod;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CrossOrigin(origins = "http://localhost:5173")
public class CartControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository; // Assuming this repository exists

    @Autowired
    private UserLoginRepository userLoginRepository; // Assuming this repository exists

    private final String BASE_URL = "http://localhost:8080/LuxuryHairVendingSystemDB/cart";

    private Product product;
    private UserLogin user;
    private CartController.CartRequest cartRequest; // Reusable cartRequest object

    @BeforeEach
    public void setup() {
        // Create and save a Product and UserLogin for testing
        product = new Product.Builder()
                .setHairTexture("Brazilian")
                .setHairStyle("Straight")
                .setHairSize("16")
                .setHairColor("Black")
                .setHairStock(true)
                .setHairPrice(100.0)
                .build();

        user = new UserLogin.Builder()
                .setEmail("testuser@example.com")
                .setPassword("password123")
                .setFullName("Test User")
                .setUserType("Customer")
                .build();

        // Save the product and user to the repository
        product = productRepository.save(product);
        user = userLoginRepository.save(user);

        // Initialize cartRequest once
        cartRequest = new CartController.CartRequest();
        cartRequest.setProduct(product);
        cartRequest.setUser(user);
        cartRequest.setQuantity(2);
    }

    @Test
    public void testAddProductToCart() {
        ResponseEntity<Cart> response = restTemplate.postForEntity(
                BASE_URL + "/add", cartRequest, Cart.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getQuantity()).isEqualTo(2);
    }

    @Test
    public void testGetCartByUserId() {
        // First, add a product to the cart for the user to test retrieval
        restTemplate.postForEntity(BASE_URL + "/add", cartRequest, Cart.class);

        ResponseEntity<Cart[]> response = restTemplate.getForEntity(
                BASE_URL + "/user/" + user.getUserId(), Cart[].class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(List.of(response.getBody())).isNotEmpty();
    }

    @Test
    public void testGetCartById() {
        // First, add a product to the cart for the user
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(BASE_URL + "/add", cartRequest, Cart.class);
        Long existingCartId = postResponse.getBody().getCartId(); // Get the ID of the newly created cart

        ResponseEntity<Cart> response = restTemplate.getForEntity(
                BASE_URL + "/item/" + existingCartId, Cart.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getCartId()).isEqualTo(existingCartId);
    }

    @Test
    public void testUpdateCartQuantity() {
        // Add a product to the cart for the user
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(BASE_URL + "/add", cartRequest, Cart.class);
        Long existingCartId = postResponse.getBody().getCartId(); // Get the ID of the newly created cart

        int newQuantity = 5;
        ResponseEntity<Cart> response = restTemplate.exchange(
                BASE_URL + "/update/" + existingCartId + "?newQuantity=" + newQuantity,
                HttpMethod.PUT,
                null,
                Cart.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getQuantity()).isEqualTo(newQuantity);
    }


    @Test
    public void testClearCartForUser() {
        // Add a product to the cart for the user
        restTemplate.postForEntity(BASE_URL + "/add", cartRequest, Cart.class);

        // Now clear the cart for the user
        ResponseEntity<Void> response = restTemplate.exchange(
                BASE_URL + "/user/" + user.getUserId() + "/clear",
                HttpMethod.DELETE,
                null,
                Void.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        // Verify that the cart is empty for the user
        ResponseEntity<Cart[]> getResponse = restTemplate.getForEntity(
                BASE_URL + "/user/" + user.getUserId(), Cart[].class);

        assertThat(getResponse.getStatusCodeValue()).isEqualTo(200);
        assertThat(getResponse.getBody()).isNotNull();
        assertThat(List.of(getResponse.getBody())).isEmpty();
    }
}
