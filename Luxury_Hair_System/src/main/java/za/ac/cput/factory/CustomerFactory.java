package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer buildCust(Long customerId, String firstName,String lastName,String email, String phone){
        if(/*Helper.isNullOrEmpty(customerId) ||*/ Helper.isNullOrEmpty(firstName)
            || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phone))
            return null;
        return new Customer.Builder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .build();
    }
}
