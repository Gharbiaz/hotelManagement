package tn.sesame.hotel_mnagament.services;

import tn.sesame.hotel_mnagament.DTO.ExperienceRequestDTO;
import tn.sesame.hotel_mnagament.DTO.ExperienceResponseDTO;

import java.util.List;

public interface IExperienceServices {
    List<ExperienceResponseDTO> getExperiences();
    ExperienceResponseDTO getExperience(long id);
    ExperienceResponseDTO addExperience(ExperienceRequestDTO experienceRequestDTO);
    ExperienceResponseDTO updateExperience(long id, ExperienceRequestDTO experienceRequestDTO);
    void deleteExperience(long id);
}
