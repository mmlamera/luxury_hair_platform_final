package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {

    public static Product buildProduct(String productID, String hairTexture, String hairStyle, String hairSize,
                                       String hairColor, boolean hairStock, double hairPrice) {
        if (Helper.isNullOrEmpty(productID) || Helper.isNullOrEmpty(hairTexture) || Helper.isNullOrEmpty(hairStyle)
                || Helper.isNullOrEmpty(hairSize) || Helper.isNullOrEmpty(hairColor))
            return null;


        return new Product.Builder().setProductId(productID)
                .setHairTexture(hairTexture)
                .setHairStyle(hairStyle)
                .setHairSize(hairSize)
                .setHairColor(hairColor)
                .setHairStock(hairStock)
                .setHairPrice(hairPrice)
                .build();

    }
}
