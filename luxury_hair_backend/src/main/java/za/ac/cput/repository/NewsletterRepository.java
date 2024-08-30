package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Newsletter;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
    Newsletter findByEmail(String email);

}