package tn.sesame.hotel_mnagament.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//jn
    @ManyToOne
    private User user;

    @ManyToOne
    private Hotel hotel;
    @OneToOne
    private Pricing price;

    @ManyToOne
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalPrice;


}