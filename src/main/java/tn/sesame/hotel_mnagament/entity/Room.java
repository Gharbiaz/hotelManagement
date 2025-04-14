package tn.sesame.hotel_mnagament.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    List<Booking> Bookings;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private int roomCount;

    private double pricePerNight;

//Availability status
    private boolean availability;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", hotel=" + hotel +
                ", roomType=" + roomType +
                ", roomCount=" + roomCount +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(hotel, room.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotel);
    }
}