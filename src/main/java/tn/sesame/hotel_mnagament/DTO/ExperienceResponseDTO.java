package tn.sesame.hotel_mnagament.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private Double price;
    private String type;
}
