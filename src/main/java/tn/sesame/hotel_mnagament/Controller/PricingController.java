package tn.sesame.hotel_mnagament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.PricingRequestDTO;
import tn.sesame.hotel_mnagament.DTO.PricingResponseDTO;
import tn.sesame.hotel_mnagament.services.PricingServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PricingController {

    private final PricingServicesImpl pricingServices;

    // Récupérer tous les prix
    @GetMapping
    public ResponseEntity<List<PricingResponseDTO>> getAllPrices() {
        List<PricingResponseDTO> prices = pricingServices.getPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    // Récupérer un prix par son ID
    @GetMapping("/{id}")
    public ResponseEntity<PricingResponseDTO> getPrice(@PathVariable long id) {
        PricingResponseDTO price = pricingServices.getPrice(id);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    // Ajouter un nouveau prix
    @PostMapping
    public ResponseEntity<PricingResponseDTO> addPrice(@RequestBody PricingRequestDTO pricingRequestDTO) {
        PricingResponseDTO newPrice = pricingServices.addPrice(pricingRequestDTO);
        return new ResponseEntity<>(newPrice, HttpStatus.CREATED);
    }

    // Mettre à jour un prix existant
    @PutMapping("/{id}")
    public ResponseEntity<PricingResponseDTO> updatePrice(@PathVariable long id, @RequestBody PricingRequestDTO pricingRequestDTO) {
        PricingResponseDTO updatedPrice = pricingServices.updatePrice(id, pricingRequestDTO);
        return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
    }

    // Supprimer un prix
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable long id) {
        pricingServices.deletePrice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
