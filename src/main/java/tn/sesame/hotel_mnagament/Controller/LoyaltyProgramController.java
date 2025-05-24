package tn.sesame.hotel_mnagament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.LoyaltyRequestDTO;
import tn.sesame.hotel_mnagament.DTO.LoyaltyResponseDTO;
import tn.sesame.hotel_mnagament.services.LoyaltyProgramServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/api/loyalty-programs")
@RequiredArgsConstructor
public class LoyaltyProgramController {

    private final LoyaltyProgramServicesImpl loyaltyProgramServices;

    // Récupérer tous les programmes de fidélité
    @GetMapping
    public ResponseEntity<List<LoyaltyResponseDTO>> getAllLoyaltyPrograms() {
        List<LoyaltyResponseDTO> loyaltyPrograms = loyaltyProgramServices.getLoyaltyPrograms();
        return new ResponseEntity<>(loyaltyPrograms, HttpStatus.OK);
    }

    // Récupérer un programme de fidélité par son ID
    @GetMapping("/{id}")
    public ResponseEntity<LoyaltyResponseDTO> getLoyaltyProgram(@PathVariable long id) {
        LoyaltyResponseDTO loyaltyProgram = loyaltyProgramServices.getLoyaltyProgram(id);
        return new ResponseEntity<>(loyaltyProgram, HttpStatus.OK);
    }

    // Ajouter un nouveau programme de fidélité
    @PostMapping
    public ResponseEntity<LoyaltyResponseDTO> addLoyaltyProgram(@RequestBody LoyaltyRequestDTO loyaltyRequestDTO) {
        LoyaltyResponseDTO newLoyaltyProgram = loyaltyProgramServices.addLoyaltyProgram(loyaltyRequestDTO);
        return new ResponseEntity<>(newLoyaltyProgram, HttpStatus.CREATED);
    }

    // Mettre à jour un programme de fidélité existant
    @PutMapping("/{id}")
    public ResponseEntity<LoyaltyResponseDTO> updateLoyaltyProgram(@PathVariable long id, @RequestBody LoyaltyRequestDTO loyaltyRequestDTO) {
        LoyaltyResponseDTO updatedLoyaltyProgram = loyaltyProgramServices.updateLoyaltyProgram(id, loyaltyRequestDTO);
        return new ResponseEntity<>(updatedLoyaltyProgram, HttpStatus.OK);
    }

    // Supprimer un programme de fidélité
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoyaltyProgram(@PathVariable long id) {
        loyaltyProgramServices.deleteLoyaltyProgram(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
