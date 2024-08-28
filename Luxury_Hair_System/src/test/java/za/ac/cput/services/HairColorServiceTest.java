package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HairColor;
import za.ac.cput.factory.HairColorFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class HairColorServiceTest {
@Autowired
private static HairColorService hairColorService;
private static HairColor color1;
    private static HairColor color2;

    @BeforeEach
    void setUp() {
        color1= HairColorFactory.buildHairColor("blk1","black","black all over", "madavha.jpg".getBytes());
        assertNotNull(color1);
        System.out.println(color1);
        color2 = HairColorFactory.buildHairColor("wht1","white","black all over", "tendani.jpg".getBytes());
        assertNotNull(color2);
        System.out.println(color2);
    }

    @Test
    void getall() {
        System.out.println(hairColorService.getall());
    }
@Order(1)
    @Test
    void create() {
        HairColor created1 = hairColorService.create(color1);
        assertNotNull(created1);
        System.out.println(created1);
        HairColor created2= hairColorService.create(color2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void read() {
        HairColor read = hairColorService.read(color2.getColorCode());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
    }
}