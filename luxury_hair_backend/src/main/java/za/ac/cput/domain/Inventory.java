package za.ac.cput.domain;

import jakarta.persistence.*;


import java.util.Objects;
@Entity
public class Inventory {

@Id
private String inventoryID;
    private String productID;
    private int quantityAv;
    private String location;
    private String supplierID;
    private double purchasePrice;

    protected Inventory() {
    }

    public Inventory(Builder builder) {
        this.inventoryID = builder.inventoryID;
        this.productID =builder.productID;
        this.quantityAv = builder.quantityAv;
        this.location =builder.location;
        this.supplierID = builder.supplierID;
        this.purchasePrice =builder.purchasePrice;
    }
 public String getInventoryID(){return inventoryID;}
    public String getProductID() {
        return productID;
    }

    public int getQuantityAv() {
        return quantityAv;
    }

    public String getLocation() {
        return location;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return quantityAv == inventory.quantityAv && Double.compare(purchasePrice, inventory.purchasePrice) == 0 && Objects.equals(productID, inventory.productID) && Objects.equals(location, inventory.location) && Objects.equals(supplierID, inventory.supplierID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryID, productID, quantityAv, location, supplierID, purchasePrice);
    }

    @Override
    public String toString() {
        return "Inventory{"+
                "inventoryID='" + inventoryID+ '\''  +
                "productID='" + productID + '\'' +
                ", quantityAv=" + quantityAv +
                ", location=" + location +
                ", supplierID='" + supplierID + '\'' +
                ", purchasePrice=" + purchasePrice +
                '}';
    }

    public static class Builder{

        private String inventoryID;
        private String productID;
        private int quantityAv;
        private String location;
        private String supplierID;
        private double purchasePrice;


        public Builder setInventoryID(String inventoryID){
            this.inventoryID = inventoryID;
            return this;
        }
        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setQuantityAv(int quantityAv) {
            this.quantityAv = quantityAv;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setSupplierID(String supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder setPurchasePrice(double purchasePrice) {
            this.purchasePrice = purchasePrice;
            return this;
        }

        public Builder copy(Inventory inv){
            this.inventoryID = inv.inventoryID;
            this.productID = inv.productID;
            this.quantityAv = inv.quantityAv;;
            this.location = inv.location;;
            this.supplierID = inv.supplierID;
            this.purchasePrice = inv.purchasePrice;
            return this;

        }
        public Inventory build(){
            return new Inventory (this);
        }
    }
}


