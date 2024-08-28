package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {

    @Autowired
    private AddressService service;
    Address address;

    @BeforeEach
    void setUp() {
        address = AddressFactory.buildAdd(22341L,32,"Corsair way","Cape Town",7765);
    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(service.getall());
    }

    @Test
    @Order(1)
    void create() {
        Address add = service.create(address);
        assertNotNull(add);
        System.out.println("Added: " + add);
    }

    @Test
    @Order(2)
    void read() {
        Address read = service.read(address.getAddressId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Address update = new Address.Builder().copy(address).setHouseNumber(43).build();
        Address updated = service.update(update);
        System.out.println(updated);
    }
}