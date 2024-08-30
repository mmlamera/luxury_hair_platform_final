package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,String> {
   // Reviews findByReviewsId(String ReviewId);
}




