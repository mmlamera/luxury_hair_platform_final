package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.UserLogin;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {

    public static Cart buildCart(Long cartId, String productId, int quantity, double price) {
        if (cartId <= 0 || Helper.isNullOrEmpty(productId) ||  quantity <= 0)
            return null;

        return new Cart.Builder().setProductId(productId)
                .setCartId(cartId)
                .setQuantity(quantity)
                .setPrice(price)
                .build();



    }

}
