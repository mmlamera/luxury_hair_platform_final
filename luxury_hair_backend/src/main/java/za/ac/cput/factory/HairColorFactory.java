package za.ac.cput.factory;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.HairColor;
import za.ac.cput.util.Helper;
public class HairColorFactory {
    public static HairColor buildHairColor(String colorCode, String colorName, String description, byte[] imageURL) {
        if (Helper.isNullOrEmpty(colorCode) || Helper.isNullOrEmpty(description) || imageURL == null) {
            return null;
        }

        return new HairColor.HairColorBuilder()
                .setColorCode(colorCode)
                .setColorName(colorName)
                .setDescription(description)
                .setImageURL(imageURL)
                .build();
    }
}
