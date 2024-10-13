package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.UserLogin;
import za.ac.cput.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Add product to cart for a specific user
    public Cart addProductToCart(Product product, UserLogin user, int quantity) {
        Cart existingCart = cartRepository.findByProduct_ProductIdAndUserLogin_UserId(product.getProductId(), user.getUserId());

        if (existingCart != null) {
            // If the product is already in the cart, use the builder pattern to update the cart
            existingCart = new Cart.Builder()
                    .copy(existingCart)  // copy existing cart
                    .setQuantity(existingCart.getQuantity() + quantity)  // update quantity
                    .build();
            return cartRepository.save(existingCart);
        }

        // Create a new cart item if it doesn't exist
        Cart newCart = new Cart.Builder()
                .setProduct(product)
                .setUserLogin(user)
                .setQuantity(quantity)
                .build();
        return cartRepository.save(newCart);
    }

    // Retrieve all cart items for a specific user by userId
    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserLogin_UserId(userId);
    }

    // Retrieve the cart item by its ID (for editing or deletion purposes)
    public Optional<Cart> getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    // Delete a specific cart item by cartId
    public void deleteCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }


    // Update the quantity of a product in the cart
    public Cart updateCartQuantity(Long cartId, int newQuantity) {
        Optional<Cart> cartOpt = cartRepository.findById(cartId);

        if (cartOpt.isPresent()) {
            Cart existingCart = cartOpt.get();
            // Use the builder pattern to update the quantity
            Cart updatedCart = new Cart.Builder()
                    .copy(existingCart)  // copy existing cart
                    .setQuantity(newQuantity)  // update the quantity
                    .build();
            return cartRepository.save(updatedCart);
        }
        return null; // handle case where cart is not found
    }

    // Delete all cart items for a specific user
    public void deleteAllCartItemsForUser(Long userId) {
        List<Cart> userCarts = cartRepository.findByUserLogin_UserId(userId);
        cartRepository.deleteAll(userCarts);
    }
}
