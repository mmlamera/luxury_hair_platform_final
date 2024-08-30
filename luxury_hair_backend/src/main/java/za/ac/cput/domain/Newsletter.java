package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long newsletterId ;
    private String email;

    public Newsletter() {
    }
    private Newsletter(Builder builder){
        this.newsletterId = builder.newsletterId;
        this.email = builder.email;
    }

    public Newsletter(Long newsletterId, String email) {
        this.newsletterId = newsletterId;
        this.email = email;
    }

    public Long getNewsletterId() {
        return newsletterId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newsletter that = (Newsletter) o;
        return Objects.equals(newsletterId, that.newsletterId) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsletterId, email);
    }

    @Override
    public String toString() {
        return "Newsletter{" +
                "newsletterId=" + newsletterId +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {
        private Long newsletterId;
        private String email;

        public Builder setNewsletterId(Long newsletterId) {
            this.newsletterId = newsletterId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Newsletter newsletter){
            this.newsletterId = newsletter.newsletterId;
            this.email = newsletter.email;
            return this;
        }
        public Newsletter build(){
            return new Newsletter(this);
        }

    }
}