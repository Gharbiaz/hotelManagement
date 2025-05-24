package tn.sesame.hotel_mnagament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.UserRequestDTO;
import tn.sesame.hotel_mnagament.DTO.UserResponseDTO;
import tn.sesame.hotel_mnagament.services.UserServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServicesImpl userServices;

    // Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userServices.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable long id) {
        UserResponseDTO user = userServices.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Ajouter un nouvel utilisateur
    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO newUser = userServices.addUser(userRequestDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Mettre à jour un utilisateur existant
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = userServices.updateUser(id, userRequestDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userServices.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
