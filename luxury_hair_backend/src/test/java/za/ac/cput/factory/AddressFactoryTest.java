package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void buildAdd() {
        Address address = AddressFactory.buildAdd(1121L,12,"Marlin road","Cape Town",7798);
        assertNotNull(address);
        System.out.println(address);
    }
}