package tn.sesame.hotel_mnagament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.ExperienceRequestDTO;
import tn.sesame.hotel_mnagament.DTO.ExperienceResponseDTO;
import tn.sesame.hotel_mnagament.services.ExperienceServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceServicesImpl experienceServices;

    // Récupérer toutes les expériences
    @GetMapping
    public ResponseEntity<List<ExperienceResponseDTO>> getAllExperiences() {
        List<ExperienceResponseDTO> experiences = experienceServices.getExperiences();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    // Récupérer une expérience par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponseDTO> getExperience(@PathVariable long id) {
        ExperienceResponseDTO experience = experienceServices.getExperience(id);
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    // Ajouter une nouvelle expérience
    @PostMapping
    public ResponseEntity<ExperienceResponseDTO> addExperience(@RequestBody ExperienceRequestDTO experienceRequestDTO) {
        ExperienceResponseDTO newExperience = experienceServices.addExperience(experienceRequestDTO);
        return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
    }

    // Mettre à jour une expérience existante
    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponseDTO> updateExperience(@PathVariable long id, @RequestBody ExperienceRequestDTO experienceRequestDTO) {
        ExperienceResponseDTO updatedExperience = experienceServices.updateExperience(id, experienceRequestDTO);
        return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
    }

    // Supprimer une expérience
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable long id) {
        experienceServices.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
