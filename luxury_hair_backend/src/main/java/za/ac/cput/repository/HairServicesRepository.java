package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.HairServices;

@Repository
public interface HairServicesRepository extends JpaRepository<HairServices, Integer> {
}