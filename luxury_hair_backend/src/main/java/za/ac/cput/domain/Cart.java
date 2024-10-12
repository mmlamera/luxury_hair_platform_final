package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id

    private Long cartId;

    private String productId;
    private int quantity;
    private double price;


    public Cart() {
    }

    public Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public Long getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return quantity == cart.quantity && Double.compare(price, cart.price) == 0 && Objects.equals(cartId, cart.cartId) && Objects.equals(productId, cart.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId, quantity, price);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Long cartId;
        private String productId;
        private int quantity;
        private double price;

        public Builder setCartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }


        public Cart.Builder copy(Cart cart){
            this.cartId = cart.cartId;
            this.productId = cart.productId;
            this.quantity = cart.quantity;
            this.price = cart.price;
            return this;
        }


        public Cart build() {
            return new Cart(this);
        }
    }
}

