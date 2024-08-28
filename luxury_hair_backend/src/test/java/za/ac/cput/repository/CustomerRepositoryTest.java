package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = CustomerFactory.buildCust(1232112L,"Masood","Lamera","mlamera@outlook.com","0874637382");
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    void findCustomerById() {
        customer = repository.findByCustomerId(1232112L);

        System.out.println(customer);

    }
}