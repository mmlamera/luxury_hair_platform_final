package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Reviews {
    @Id
    private String ReviewId;
    private String ReviewTitle;
    private String ReviewDescription;
    private String ReviewDate;
    private  int Rating;
    private String serviceName;
    private String ReviewStatus;
    private String imageUrl;

    public Reviews(){

    }
    public Reviews(Builder builder){
        this.ReviewId=builder.ReviewId;
        this.ReviewTitle=builder.ReviewTitle;
        this.ReviewDescription=builder.ReviewDescription;
        this.Rating=builder.Rating;
        this.ReviewDate=builder.ReviewDate;
        this.serviceName=builder.serviceName;
        this.ReviewStatus=builder.ReviewStatus;
        this.imageUrl=builder.imageUrl;

    }
    public String getReviewId() {
        return ReviewId;
    }

    public String getReviewTitle() {
        return ReviewTitle;
    }

    public String getReviewDescription() {
        return ReviewDescription;
    }
    public String getReviewDate() {
        return ReviewDate;
    }
    public int getRating() {
        return Rating;
    }
    public String getServiceName() {
        return serviceName;
    }
    public String getReviewStatus() {
        return ReviewStatus;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reviews reviews)) return false;
        return Rating == reviews.Rating && Objects.equals(ReviewId, reviews.ReviewId) && Objects.equals(ReviewTitle, reviews.ReviewTitle) && Objects.equals(ReviewDescription, reviews.ReviewDescription) && Objects.equals(ReviewDate, reviews.ReviewDate) && Objects.equals(serviceName, reviews.serviceName) && Objects.equals(ReviewStatus, reviews.ReviewStatus) && Objects.equals(imageUrl, reviews.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ReviewId, ReviewTitle, ReviewDescription, ReviewDate, Rating, serviceName, ReviewStatus, imageUrl);
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "ReviewId='" + ReviewId + '\'' +
                ", ReviewTitle='" + ReviewTitle + '\'' +
                ", ReviewDescription='" + ReviewDescription + '\'' +
                ", ReviewDate='" + ReviewDate + '\'' +
                ", Rating=" + Rating +
                ", serviceName='" + serviceName + '\'' +
                ", ReviewStatus='" + ReviewStatus + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
    public static class Builder{
        private String ReviewId;
        private String ReviewTitle;
        private String ReviewDescription;
        private String ReviewDate;
        private int Rating;
        private String serviceName;
        private String ReviewStatus;
        private String imageUrl;

        public Builder setReviewId(String ReviewId) {
            this.ReviewId = ReviewId;
            return this;
        }
        public Builder setReviewTitle(String ReviewTitle) {
            this.ReviewTitle = ReviewTitle;
            return this;
        }
        public Builder setReviewDescription(String ReviewDescription) {
            this.ReviewDescription = ReviewDescription;
            return this;
        }
        public Builder setReviewDate(String ReviewDate) {
            this.ReviewDate = ReviewDate;
            return this;
        }
        public Builder setRating(int Rating) {
            this.Rating = Rating;
            return this;
        }
        public Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Builder setReviewStatus(String ReviewStatus) {
            this.ReviewStatus = ReviewStatus;
            return this;
        }
        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }
        public Builder copy(Reviews reviews){
            this.ReviewId=reviews.ReviewId;
            this.ReviewTitle=reviews.ReviewTitle;
            this.ReviewDescription=reviews.ReviewDescription;
            this.ReviewDate=reviews.ReviewDate;
            this.Rating=reviews.Rating;
            this.serviceName=reviews.serviceName;
            this.ReviewStatus=reviews.ReviewStatus;
            this.imageUrl=reviews.imageUrl;
            return this;
        }
        public Reviews build(){
            return new Reviews(this);
        }
    }
}