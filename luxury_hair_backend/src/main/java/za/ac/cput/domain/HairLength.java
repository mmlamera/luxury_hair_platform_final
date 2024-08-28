package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class HairLength {
    @Id
    private int hairlengthID;
    private int hairLengthValue;
    private String lengthDescription;

    public HairLength() {
    }

    public HairLength(Builder builder) {
        hairlengthID = builder.hairlengthID;
        hairLengthValue = builder.hairLengthValue;
        lengthDescription = builder.lengthDescription;
    }

    public int getHairlengthID() {
        return hairlengthID;
    }

    public int getHairLengthValue() {
        return hairLengthValue;
    }

    public String getLengthDescription() {
        return lengthDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HairLength that = (HairLength) o;
        return hairlengthID == that.hairlengthID && hairLengthValue == that.hairLengthValue && Objects.equals(lengthDescription, that.lengthDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hairlengthID, hairLengthValue, lengthDescription);
    }

    @Override
    public String toString() {
        return "HairLength{" +
                "hairlengthID=" + hairlengthID +
                ", hairLengthValue=" + hairLengthValue +
                ", lengthDescription='" + lengthDescription + '\'' +
                '}';
    }

    public static class Builder {
        private int hairlengthID;
        private int hairLengthValue;
        private String lengthDescription;

        public Builder setHairlengthID(int hairlengthID) {
            this.hairlengthID = hairlengthID;
            return this;
        }

        public Builder setHairLengthValue(int hairLengthValue) {
            this.hairLengthValue = hairLengthValue;
            return this;
        }

        public Builder setLengthDescription(String lengthDescription) {
            this.lengthDescription = lengthDescription;
            return this;
        }

        public Builder copy(HairLength hairLength) {
            hairlengthID = hairLength.hairlengthID;
            hairLengthValue = hairLength.hairLengthValue;
            lengthDescription = hairLength.lengthDescription;
            return this;
        }

        public HairLength build() {
            return new HairLength(this);
        }
    }
}
