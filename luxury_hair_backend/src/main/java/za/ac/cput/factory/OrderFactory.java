package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

public class OrderFactory {
    public static Order buildOrder(String orderID,  int quantity, double totalPrice, String orderDate, String orderStatus, String shippingAddress, String shippingMethod, String paymentMethod) {
        if (Helper.isNullOrEmpty(orderID) || Helper.isNullOrEmpty(String.valueOf(quantity)) || Helper.isNullOrEmpty(String.valueOf(totalPrice)) || Helper.isNullOrEmpty(String.valueOf(orderDate)) || Helper.isNullOrEmpty(shippingAddress) || Helper.isNullOrEmpty(shippingMethod) || Helper.isNullOrEmpty(paymentMethod))
            return null;
        return new Order.Builder().setOrderID(orderID)
                .setQuantity(quantity)
                .setTotalPrice(totalPrice)
                .setOrderStatus(orderStatus)
                .setOrderDate(orderDate)
                .setShippingAddress(shippingAddress)
                .setShippingMethod(shippingMethod)
                .setPaymentMethod(paymentMethod).build();

    }
}