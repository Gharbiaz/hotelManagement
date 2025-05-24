package tn.sesame.hotel_mnagament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.RoomRequestDto;
import tn.sesame.hotel_mnagament.DTO.RoomResponseDTO;
import tn.sesame.hotel_mnagament.services.RoomServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomServicesImpl roomServices;

    // Récupérer toutes les chambres
    @GetMapping
    public ResponseEntity<List<RoomResponseDTO>> getAllRooms() {
        List<RoomResponseDTO> rooms = roomServices.getRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    // Récupérer une chambre par son ID
    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDTO> getRoom(@PathVariable long id) {
        RoomResponseDTO room = roomServices.getRoom(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    // Ajouter une nouvelle chambre
    @PostMapping
    public ResponseEntity<RoomResponseDTO> addRoom(@RequestBody RoomRequestDto roomRequestDTO) {
        RoomResponseDTO newRoom = roomServices.addRoom(roomRequestDTO);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    // Mettre à jour une chambre existante
    @PutMapping("/{id}")
    public ResponseEntity<RoomResponseDTO> updateRoom(@PathVariable long id, @RequestBody RoomRequestDto roomRequestDTO) {
        RoomResponseDTO updatedRoom = roomServices.updateRoom(id, roomRequestDTO);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    // Supprimer une chambre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable long id) {
        roomServices.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
