package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {

    public static Payment buildPayment(String cardNumber, String name, String email, String cardType, String expiryDate, String cvv, String paymentMethod, Double totalAmount, Long paymentID) {
        if (Helper.isNullOrEmpty(cardNumber) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(cardType) || Helper.isNullOrEmpty(expiryDate) || Helper.isNullOrEmpty(cvv) || Helper.isNullOrEmpty(String.valueOf(paymentID)) || Helper.isNullOrEmpty(paymentMethod) || totalAmount == null) {
        }


        return new Payment.Builder().setCardNumber(cardNumber)
                .setName(name)
                .setEmail(email)
                .setCardType(cardType)
                .setExpiryDate(expiryDate)
                .setCvv(cvv)
                .setPaymentMethod(paymentMethod)
                .setTotalAmount(totalAmount)
                .setPaymentID(paymentID)
                .build();

    }
}