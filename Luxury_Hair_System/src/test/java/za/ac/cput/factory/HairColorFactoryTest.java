package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.HairColor;

import static org.junit.jupiter.api.Assertions.*;

class HairColorFactoryTest {

        private HairColor hairColor1;
        private HairColor hairColor2;
        private HairColor hairColor3;
        private HairColor hairColor4;

        @BeforeEach
        void setUp() {
            String colorCode = "pnk1";
            String colorName = "Pink";
            String description = "This color has different shades of pink";
            byte[] imageURL = new byte[]{0x12, 0x34, 0x56};

            hairColor1 = HairColorFactory.buildHairColor("pnk1", "Pink", "This color has different shades of pink", imageURL);
            hairColor2 = HairColorFactory.buildHairColor(colorCode, null, description, imageURL);
            hairColor3 = HairColorFactory.buildHairColor(colorCode, colorName, description, null);
            hairColor4 = HairColorFactory.buildHairColor(colorCode, colorName, description, imageURL);
        }

        @Test
        void testBuildHairColor_withValidData() {
            assertNotNull(hairColor1);
            assertEquals("pnk1", hairColor1.getColorCode());
            assertEquals("Pink", hairColor1.getColorName());
            assertEquals("This color has different shades of pink", hairColor1.getDescription());
            assertArrayEquals(new byte[]{0x12, 0x34, 0x56}, hairColor1.getImageURL());
        }

        @Test
        void testBuildHairColor_withNullColorName() {
            assertNull(hairColor2);
        }

        @Test
        void testBuildHairColor_withNullImageURL() {
            assertNull(hairColor3);
        }

        @Test
        void testIdentity() {
            assertNotSame(hairColor1, hairColor4);
        }

        @Test
        void testEquality() {
            assertEquals(hairColor1, hairColor4);
        }

        @Test
        void testHashCode() {
            assertEquals(hairColor1.hashCode(), hairColor4.hashCode());
        }
    }