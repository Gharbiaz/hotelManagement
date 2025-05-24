package tn.sesame.hotel_mnagament.services;

import tn.sesame.hotel_mnagament.DTO.LoyaltyRequestDTO;
import tn.sesame.hotel_mnagament.DTO.LoyaltyResponseDTO;

import java.util.List;

public interface ILoyaltyProgramServices {
    List<LoyaltyResponseDTO> getLoyaltyPrograms();
    LoyaltyResponseDTO getLoyaltyProgram(long id);
    LoyaltyResponseDTO addLoyaltyProgram(LoyaltyRequestDTO loyaltyProgramRequestDTO);
    LoyaltyResponseDTO updateLoyaltyProgram(long id, LoyaltyRequestDTO loyaltyProgramRequestDTO);
    void deleteLoyaltyProgram(long id);
}
