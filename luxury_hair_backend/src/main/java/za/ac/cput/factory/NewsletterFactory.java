package za.ac.cput.factory;

import za.ac.cput.domain.Newsletter;
import za.ac.cput.util.Helper;

public class NewsletterFactory {
    public static Newsletter buildNewsletter(Long newsletterId,String email){
        if (Helper.isNullOrEmpty(String.valueOf(newsletterId)) || Helper.isNullOrEmpty(email))
            return null;
        return new Newsletter.Builder().setNewsletterId(newsletterId).setEmail(email).build();
    }
}