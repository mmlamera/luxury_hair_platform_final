package za.ac.cput.factory;
import za.ac.cput.domain.Supplier;
import za.ac.cput.util.Helper;

public class SupplierFactory {


    public static Supplier buildSupplier(String supplierID, String Name, String phoneNumber,
                                         String emailAddress, String paymentMethod, String productsSupplied) {
        if (Helper.isNullOrEmpty(supplierID) || Helper.isNullOrEmpty(Name) || Helper.isNullOrEmpty(phoneNumber)
                || Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(productsSupplied))
            return null;

        return new Supplier.Builder().setSupplierID(supplierID)
                .setName(Name)
                .setPhoneNumber(phoneNumber)
                .setPaymentMethod(paymentMethod)
                .setEmailAddress(emailAddress)
                .setProductsSupplied(productsSupplied)
                .build();
    }
}
