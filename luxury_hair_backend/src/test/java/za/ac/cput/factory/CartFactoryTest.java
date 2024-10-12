package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void buildCart() {
        Cart cart = CartFactory.buildCart(21L,"A77", 3, 4500.00);
        assertNotNull(cart);
        System.out.println(cart);
    }
}