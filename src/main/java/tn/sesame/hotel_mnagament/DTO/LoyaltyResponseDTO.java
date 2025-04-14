package tn.sesame.hotel_mnagament.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyResponseDTO {
    private Long id;
    private Long userId;
    private int points;
    private String level;
}
