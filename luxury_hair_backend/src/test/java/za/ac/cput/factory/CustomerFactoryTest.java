package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {


    @Test
    void buildCust() {
        Customer customer = CustomerFactory.buildCust(221376L,"Thaakirha","Watson","twatson@gmail.com","0718871857");
        assertNotNull(customer);
        System.out.println(customer);
    }
}