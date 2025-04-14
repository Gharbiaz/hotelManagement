package tn.sesame.hotel_mnagament.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Double pricePerNight;
    private Boolean availability;
    private String roomDetails; // Nouveau champ ajouté

    @OneToMany(mappedBy = "hotel")
    List<Booking> bookings;
}

