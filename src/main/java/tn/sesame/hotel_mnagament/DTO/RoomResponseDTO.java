package tn.sesame.hotel_mnagament.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDTO {
    private Long id;
    private String type;
    private boolean available;
    private Double price;
    private Long hotelId;
}
