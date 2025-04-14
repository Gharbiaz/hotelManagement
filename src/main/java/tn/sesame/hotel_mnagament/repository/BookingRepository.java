package tn.sesame.hotel_mnagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sesame.hotel_mnagament.entity.Booking;
import tn.sesame.hotel_mnagament.entity.Hotel;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
