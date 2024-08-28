package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Supplier {
    @Id
    private String supplierID;
    private String Name;
    private String phoneNumber;
    private String emailAddress;
    private String paymentMethod;
    private String productsSupplied;

    public Supplier() {
    }

    public Supplier(Builder builder) {
        this.supplierID = builder.supplierID;
        this.Name = builder.Name;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
        this.paymentMethod = builder.paymentMethod;
        this.productsSupplied = builder.productsSupplied;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getProductsSupplied() {
        return productsSupplied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierID, supplier.supplierID) && Objects.equals(Name, supplier.Name) && Objects.equals(phoneNumber, supplier.phoneNumber) && Objects.equals(emailAddress, supplier.emailAddress) && Objects.equals(paymentMethod, supplier.paymentMethod) && Objects.equals(productsSupplied, supplier.productsSupplied);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierID, Name, phoneNumber, emailAddress, paymentMethod, productsSupplied);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID='" + supplierID + '\'' +
                ", Name='" + Name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", productsSupplied='" + productsSupplied + '\'' +
                '}';
    }

    public static class Builder {
        private String supplierID;
        private String Name;
        private String phoneNumber;
        private String emailAddress;
        private String paymentMethod;
        private String productsSupplied;

        public Builder setSupplierID(String supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder setName(String name) {
            this.Name = name;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setProductsSupplied(String productsSupplied) {
            this.productsSupplied = productsSupplied;
            return this;
        }
        public Builder copy(Supplier supplier){
            this.supplierID = supplier.supplierID;
            this.Name = supplier.Name;
            this.phoneNumber = supplier.phoneNumber;
            this.emailAddress = supplier.emailAddress;
            this.paymentMethod = supplier.paymentMethod;
            this.productsSupplied = supplier.productsSupplied;
            return this;
        }
        public Supplier build(){
            return new Supplier(this);
        }
    }
}
