package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private CartRepository repository;
    private Cart cart;


    @BeforeEach
    void setUp() {
        cart = CartFactory.buildCart(22L, "A77",2,4500.00);
        assertNotNull(cart);
        System.out.println(cart);
    }


    @Test
    void findByProductId() {
        cart = repository.findByProductId("A77");
        System.out.println(cart);
    }

    @Test
    void findByCartId() {
        cart = repository.findByCartId(2L);
        System.out.println(cart);
    }
}