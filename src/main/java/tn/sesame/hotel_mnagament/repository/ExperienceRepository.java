package tn.sesame.hotel_mnagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sesame.hotel_mnagament.entity.Experience;

@Repository
public interface ExperienceRepository  extends JpaRepository<Experience, Long> {
    // Custom query methods can be defined here if needed
}
