package tn.sesame.hotel_mnagament.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.ExperienceRequestDTO;
import tn.sesame.hotel_mnagament.DTO.ExperienceResponseDTO;
import tn.sesame.hotel_mnagament.entity.Experience;
import tn.sesame.hotel_mnagament.repository.ExperienceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceServicesImpl implements IExperienceServices {

    private final ExperienceRepository experienceRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ExperienceResponseDTO> getExperiences() {
        return experienceRepository.findAll()
                .stream()
                .map(experience -> modelMapper.map(experience, ExperienceResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExperienceResponseDTO getExperience(long id) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Experience not found with id: " + id));
        return modelMapper.map(experience, ExperienceResponseDTO.class);
    }

    @Override
    public ExperienceResponseDTO addExperience(ExperienceRequestDTO experienceRequestDTO) {
        Experience experience = modelMapper.map(experienceRequestDTO, Experience.class);
        Experience savedExperience = experienceRepository.save(experience);
        return modelMapper.map(savedExperience, ExperienceResponseDTO.class);
    }

    @Override
    public ExperienceResponseDTO updateExperience(long id, ExperienceRequestDTO experienceRequestDTO) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Experience not found with id: " + id));

        // Map only the necessary fields
        modelMapper.map(experienceRequestDTO, experience);

        Experience updatedExperience = experienceRepository.save(experience);
        return modelMapper.map(updatedExperience, ExperienceResponseDTO.class);
    }

    @Override
    public void deleteExperience(long id) {
        if (!experienceRepository.existsById(id)) {
            throw new IllegalArgumentException("Experience not found with id: " + id);
        }
        experienceRepository.deleteById(id);
    }
}
