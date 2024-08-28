package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.HairLength;

@Repository
public interface HairLengthRepository extends JpaRepository<HairLength, String> {
}
