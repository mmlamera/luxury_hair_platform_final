package za.ac.cput.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CartServiceTest {


    @Autowired
    private CartService cartService;

    Cart cart;

    @BeforeEach
    void setUp() {
        cart = CartFactory.buildCart(99L,"A51", 1, 3500.00);
        assertNotNull(cart);
        System.out.println(cart);
    }


    @Test
    void getall() {
        System.out.println(cartService.getall());
    }

    @Test
    void delete() {
        cartService.delete(cart.getCartId());
    }

    @Test
    void create() {
        Cart create = cartService.create(cart);
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    void read() {
        Cart read = cartService.read(cart.getCartId());
        System.out.println(read);
    }

    @Test
    void update() {
        Cart updateCart =new Cart.Builder().copy(cart).setCartId(99L).build();
        Cart updated = cartService.update(updateCart);
        assertNotNull(updated);
        System.out.println(updated);
    }
}