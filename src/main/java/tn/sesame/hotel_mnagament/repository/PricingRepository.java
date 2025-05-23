package tn.sesame.hotel_mnagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sesame.hotel_mnagament.entity.Pricing;
@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
    // Custom query methods can be defined here if needed
}
