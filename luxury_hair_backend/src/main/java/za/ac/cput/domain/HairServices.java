package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class HairServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hairServicesId;

    @Lob
    @Column(length = 1000000) // Adjust length as needed
    private byte[] image;

    private LocalDate date;
    private LocalTime time;
    private String additionalNotes;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    // Default constructor
    public HairServices() {}

    public HairServices(Builder builder) {
        this.hairServicesId = builder.hairServicesId;
        this.image = builder.image;
        this.date = builder.date;
        this.time = builder.time;
        this.additionalNotes = builder.additionalNotes;
        this.customer = builder.customer;
    }

    public int getHairServicesId() {
        return hairServicesId;
    }

    public byte[] getImage() {
        return image;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HairServices that = (HairServices) o;
        return hairServicesId == that.hairServicesId &&
                Arrays.equals(image, that.image) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(additionalNotes, that.additionalNotes) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(hairServicesId, date, time, additionalNotes, customer);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "HairServices{" +
                "hairServicesId=" + hairServicesId +
                ", image=" + Arrays.toString(image) +
                ", date=" + date +
                ", time=" + time +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", customer=" + customer +
                '}';
    }

    // Builder Class
    public static class Builder {
        private int hairServicesId;
        private byte[] image;
        private LocalDate date;
        private LocalTime time;
        private String additionalNotes;
        private Customer customer;

        public Builder setHairServicesId(int hairServicesId) {
            this.hairServicesId = hairServicesId;
            return this;
        }

        public Builder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder setAdditionalNotes(String additionalNotes) {
            this.additionalNotes = additionalNotes;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(HairServices hairServices) {
            this.hairServicesId = hairServices.hairServicesId;
            this.image = hairServices.image;
            this.date = hairServices.date;
            this.time = hairServices.time;
            this.additionalNotes = hairServices.additionalNotes;
            this.customer = hairServices.customer;
            return this;
        }

        public HairServices build() {
            return new HairServices(this);
        }
    }
}