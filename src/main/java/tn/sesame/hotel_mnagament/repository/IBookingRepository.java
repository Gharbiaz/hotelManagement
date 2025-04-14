package tn.sesame.hotel_mnagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sesame.hotel_mnagament.entity.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

}
