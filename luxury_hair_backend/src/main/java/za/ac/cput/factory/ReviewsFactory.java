package za.ac.cput.factory;

import za.ac.cput.domain.Reviews;
import za.ac.cput.util.Helper;

public class ReviewsFactory {
    public static Reviews buildReviews(String ReviewId,String ReviewTitle,String ReviewDescription,String ReviewDate,int Rating,String serviceName,String ReviewStatus,String imageUrl) {
        if(Helper.isNullOrEmpty(ReviewId)||Helper.isNullOrEmpty(ReviewTitle)||Helper.isNullOrEmpty(ReviewDescription)||Helper.isNullOrEmpty(ReviewDate)||Helper.isNullOrEmpty(String.valueOf(Rating))||Helper.isNullOrEmpty(serviceName)||Helper.isNullOrEmpty(ReviewStatus)||Helper.isNullOrEmpty(imageUrl))
            return null;
        return new Reviews.Builder().setReviewId(ReviewId)
                .setReviewTitle(ReviewTitle)
                .setReviewDescription(ReviewDescription)
                .setReviewDate(ReviewDate)
                .setRating(Rating).setServiceName(serviceName).setReviewStatus(ReviewStatus).setImageUrl(imageUrl).build();

    }
}