package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.HairColor;

@Repository
public interface HairColorRepository extends JpaRepository<HairColor, String> {
}

