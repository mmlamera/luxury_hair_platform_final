package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Retrieve all cart items by userId
    List<Cart> findByUserLogin_UserId(Long userId);

    // Find cart item by productId and userId (to avoid duplicates in the cart)
    Cart findByProduct_ProductIdAndUserLogin_UserId(Long productId, Long userId);
}
