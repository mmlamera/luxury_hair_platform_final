package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class HairColor {
    @Id
    private String colorCode;
    private String colorName;
    private String description;

    @Lob
    private byte[] imageURL;

    protected HairColor() {
    }

    public HairColor(HairColorBuilder builder) {
        this.colorCode = builder.colorCode;
        this.colorName = builder.colorName;
        this.description = builder.description;
        this.imageURL = builder.imageURL;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImageURL() {
        return imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HairColor hairColor = (HairColor) o;
        return Objects.equals(colorCode, hairColor.colorCode) && Objects.equals(colorName, hairColor.colorName) && Objects.equals(description, hairColor.description) && Arrays.equals(imageURL, hairColor.imageURL);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(colorCode, colorName, description);
        result = 31 * result + Arrays.hashCode(imageURL);
        return result;
    }

    @Override
    public String toString() {
        return "HairColor{" +
                "colorCode='" + colorCode + '\'' +
                ", colorName='" + colorName + '\'' +
                ", description='" + description + '\'' +
                ", imageURL=" + Arrays.toString(imageURL) +
                '}';
    }

    public static class HairColorBuilder {
        private String colorCode;
        private String colorName;
        private String description;
        private byte[] imageURL;

        public HairColorBuilder setColorCode(String colorCode) {
            this.colorCode = colorCode;
            return this;
        }

        public HairColorBuilder setColorName(String colorName) {
            this.colorName = colorName;
            return this;
        }

        public HairColorBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public HairColorBuilder setImageURL(byte[] imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public HairColorBuilder copy(HairColor hairColor) {
            this.colorCode = hairColor.colorCode;
            this.colorName = hairColor.colorName;
            this.description = hairColor.description;
            this.imageURL = hairColor.imageURL;
            return this;
        }

        public HairColor build() {
            return new HairColor(this);
        }
    }
}