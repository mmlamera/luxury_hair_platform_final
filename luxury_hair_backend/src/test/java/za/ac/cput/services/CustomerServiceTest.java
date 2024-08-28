package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {
@Autowired
private CustomerService customerService;
    Customer customer;
    @BeforeEach
    void setUp() {
        customer = CustomerFactory.buildCust(332423L,"Michael","Ross","mross@outlook.com","0787564473");
    }

    @Test
    @Order(1)
    void create() {
        Customer customer1 = customerService.create(customer);
        assertNotNull(customer1);
        System.out.println(customer1);
    }

    @Test
    @Order(2)
    void read() {
        Customer read = customerService.read(customer.getCustomerId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Customer updateCustomer = new Customer.Builder().copy(customer).setLastName("Jackson").build();
        Customer update = customerService.update(updateCustomer);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(customerService.getall());
    }
}