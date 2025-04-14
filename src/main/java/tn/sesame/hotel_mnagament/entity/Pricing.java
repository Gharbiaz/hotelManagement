package tn.sesame.hotel_mnagament.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Hotel hotel;

    private Double basePrice;
    private Double dynamicPrice;
    private LocalDateTime lastUpdated;

    // Méthodes

}
