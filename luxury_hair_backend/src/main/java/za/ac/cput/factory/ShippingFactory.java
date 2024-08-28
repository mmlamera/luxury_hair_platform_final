package za.ac.cput.factory;

import za.ac.cput.domain.Shipping;
import za.ac.cput.util.Helper;

public class ShippingFactory {
    public static Shipping buildShipping(String shippingID, String orderID, String shippingCourier, int trackingNumber, double shippingCost,String shippingDate, String estimatedDeliveryDate, String deliveryStatus) {
        if (Helper.isNullOrEmpty(shippingID) || Helper.isNullOrEmpty(orderID) || Helper.isNullOrEmpty(shippingCourier) || Helper.isNullOrEmpty(String.valueOf(trackingNumber)) || Helper.isNullOrEmpty(String.valueOf(shippingCost)) || Helper.isNullOrEmpty(shippingDate)|| Helper.isNullOrEmpty(estimatedDeliveryDate) || Helper.isNullOrEmpty(deliveryStatus))
            return null;
        return new Shipping.Builder()
                .setShippingID(shippingID)
                .setOrderID(orderID)
                .setShippingCourier(shippingCourier)
                .setTrackingNumber(trackingNumber)
                .setEstimatedDeliveryDate(estimatedDeliveryDate)
                .setDeliveryStatus(deliveryStatus)
                .build();
    }

    public static Shipping buildShipping(String orderID, String shippingCourier, int trackingNumber, double shippingCost,String shippingDate, String estimatedDeliveryDate, String deliveryStatus) {
        if (Helper.isNullOrEmpty(orderID) || Helper.isNullOrEmpty(shippingCourier) || Helper.isNullOrEmpty(String.valueOf(trackingNumber)) || Helper.isNullOrEmpty(String.valueOf(shippingCost)) || Helper.isNullOrEmpty(shippingDate) || Helper.isNullOrEmpty(estimatedDeliveryDate) || Helper.isNullOrEmpty(deliveryStatus))
            return null;
        String shippingID =Helper.generateId();
        return new Shipping.Builder()
                .setShippingID(shippingID)
                .setOrderID(orderID)
                .setShippingCourier(shippingCourier)
                .setTrackingNumber(trackingNumber)
                .setEstimatedDeliveryDate(estimatedDeliveryDate)
                .setDeliveryStatus(deliveryStatus)
                .build();
    }
}
