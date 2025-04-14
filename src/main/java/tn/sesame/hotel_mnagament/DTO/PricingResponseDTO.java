package tn.sesame.hotel_mnagament.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
public class PricingResponseDTO {
    private Long id;
    private Long roomId;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;
}
