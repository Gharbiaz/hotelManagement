package tn.sesame.hotel_mnagament.services;

import tn.sesame.hotel_mnagament.DTO.PricingRequestDTO;
import tn.sesame.hotel_mnagament.DTO.PricingResponseDTO;

import java.util.List;

public interface IPricingServices {
    List<PricingResponseDTO> getPrices();
    PricingResponseDTO getPrice(long id);
    PricingResponseDTO addPrice(PricingRequestDTO pricingRequestDTO);
    PricingResponseDTO updatePrice(long id, PricingRequestDTO pricingRequestDTO);
    void deletePrice(long id);
}
