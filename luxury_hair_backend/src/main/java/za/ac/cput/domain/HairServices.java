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
    @Column(length = 1000000000)
    protected byte[] image;

    protected LocalDate date;
    protected LocalTime time;
    protected String additionalNotes;

    // Default constructor
    protected HairServices() {
    }

    public HairServices(Builder builder) {
        this.hairServicesId = builder.hairServicesId;
        this.image = builder.image;
        this.date = builder.date;
        this.time = builder.time;
        this.additionalNotes = builder.additionalNotes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HairServices that = (HairServices) o;
        return hairServicesId == that.hairServicesId &&
                Arrays.equals(image, that.image) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(additionalNotes, that.additionalNotes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(hairServicesId, date, time, additionalNotes);
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
                '}';
    }


    // Builder Class
    public static class Builder {
        private int hairServicesId;
        private byte[] image;
        private LocalDate date;
        private LocalTime time;
        private String additionalNotes;

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

        public Builder copy(HairServices hairServices) {
            this.hairServicesId = hairServices.hairServicesId;
            this.image = hairServices.image;
            this.date = hairServices.date;
            this.time = hairServices.time;
            this.additionalNotes = hairServices.additionalNotes;
            return this;
        }

        public HairServices build() {
            return new HairServices(this);
        }
    }
}