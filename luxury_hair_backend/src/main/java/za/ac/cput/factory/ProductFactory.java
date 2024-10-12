package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {

    public static Product buildProduct( String hairTexture, String hairStyle, String hairSize,
                                       String hairColor, boolean hairStock, double hairPrice, byte[] image) {
        if (image == null || image.length == 0) {
            image = new byte[0];
        }

        if ( Helper.isNullOrEmpty(hairTexture) || Helper.isNullOrEmpty(hairStyle)
                || Helper.isNullOrEmpty(hairSize) || Helper.isNullOrEmpty(hairColor))
            return null;


        return new Product.Builder()
                .setHairTexture(hairTexture)
                .setHairStyle(hairStyle)
                .setHairSize(hairSize)
                .setHairColor(hairColor)
                .setHairStock(hairStock)
                .setHairPrice(hairPrice)
                .setImage(image)
                .build();

    }
}
