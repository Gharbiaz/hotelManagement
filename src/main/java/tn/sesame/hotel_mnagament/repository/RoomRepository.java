package tn.sesame.hotel_mnagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sesame.hotel_mnagament.entity.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
}
