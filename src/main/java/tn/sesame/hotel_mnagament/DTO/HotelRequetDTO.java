package tn.sesame.hotel_mnagament.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class HotelRequetDTO {
    private String name;
    private String city;
    private String address;
    private String description;
    private Double rating;
}
