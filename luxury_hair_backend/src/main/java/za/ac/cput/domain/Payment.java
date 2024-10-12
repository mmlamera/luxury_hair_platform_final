package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class
Payment {
    @Id
    private Long paymentID;
    private String cardNumber;
    private String name;
    private String email;
    private String cardType;
    private String expiryDate;
    private String cvv;
    private String paymentMethod;
    private double totalAmount;

    public Payment() {
    }

    public Payment(Builder builder) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.email = email;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.paymentID = paymentID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCardType() {
        return cardType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Long getPaymentID() {
        return paymentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(totalAmount, payment.totalAmount) == 0 && Objects.equals(paymentID, payment.paymentID) && Objects.equals(cardNumber, payment.cardNumber) && Objects.equals(name, payment.name) && Objects.equals(email, payment.email) && Objects.equals(cardType, payment.cardType) && Objects.equals(expiryDate, payment.expiryDate) && Objects.equals(cvv, payment.cvv) && Objects.equals(paymentMethod, payment.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, cardNumber, name, email, cardType, expiryDate, cvv, paymentMethod, totalAmount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", cardNumber='" + cardNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cardType='" + cardType + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public Payment.Builder Builder(){
        return null;
    }
    public static class Builder {
       // public Payment build;
        private String cardNumber;
        private String name;
        private String email;
        private String cardType;
        private String expiryDate;
        private String cvv;
        private String paymentMethod;
        private double totalAmount;
        private Long paymentID;

        public Builder setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setCardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        public Builder setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder setCvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setPaymentID(Long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder copy(Payment payment) {
            return null;
        }

        public Payment build() {
            return null;
        }
    }
    //public Builder copy(Payment payment) {
    //this.cardNumber = payment.cardNumber;
    //this.name = payment.name;
    // this.email = payment.email;
    //this.cardType = payment.cardType;
    // this.expiryDate = payment.expiryDate;
    //this.cvv = payment.cvv;
    //this.paymentMethod = payment.paymentMethod;
    //this.totalAmount = payment.totalAmount;
    //return this.Builder();
    //}
    // public Payment build() {
    // return new Payment(this.Builder());
    //}

}