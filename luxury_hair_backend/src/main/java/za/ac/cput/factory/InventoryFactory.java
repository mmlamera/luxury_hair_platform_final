package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.util.Helper;


public class InventoryFactory {
    public static Inventory buildInventory(String inventoryID, String productID, int quantityAv, String location, String supplierID, double purchasePrice){
        if(Helper.isNullOrEmpty(inventoryID)|| Helper.isNullOrEmpty(productID) || Helper.isNullOrEmpty(String.valueOf(quantityAv)) || Helper.isNullOrEmpty(location) || Helper.isNullOrEmpty(supplierID) || Helper.isNullOrEmpty(String.valueOf(purchasePrice)))
            return null;

        return new Inventory.Builder()
                .setInventoryID(inventoryID)
                .setProductID(productID)
                .setQuantityAv(quantityAv)
                .setLocation(location)
                .setSupplierID(supplierID)
                .setPurchasePrice(purchasePrice)
                .build();


    }
    public static Inventory buildInventory( String productID, int quantityAv, String location, String supplierID, double purchasePrice){
        if(Helper.isNullOrEmpty(String.valueOf(quantityAv)) || Helper.isNullOrEmpty(String.valueOf(location)) || Helper.isNullOrEmpty(supplierID) || Helper.isNullOrEmpty(String.valueOf(purchasePrice)))
            return null;
        String inventoryID =Helper.generateId();

        return new Inventory.Builder()
                .setProductID(productID)
                .setQuantityAv(quantityAv)
                .setLocation(location)
                .setSupplierID(supplierID)
                .setPurchasePrice(purchasePrice)
                .build();
    }
}
