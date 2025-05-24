package tn.sesame.hotel_mnagament.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.BookingRequestDTO;
import tn.sesame.hotel_mnagament.DTO.BookingResponseDTO;
import tn.sesame.hotel_mnagament.services.BookingServicesImpl;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServicesImpl bookingServices;

    // Récupérer toutes les réservations
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        List<BookingResponseDTO> bookings = bookingServices.getBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Récupérer une réservation par son ID
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBooking(@PathVariable long id) {
        BookingResponseDTO booking = bookingServices.getBooking(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    // Ajouter une nouvelle réservation
    @PostMapping
    public ResponseEntity<BookingResponseDTO> addBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO newBooking = bookingServices.addBooking(bookingRequestDTO);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    // Mettre à jour une réservation existante
    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable long id, @RequestBody BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO updatedBooking = bookingServices.updateBooking(id, bookingRequestDTO);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    // Supprimer une réservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable long id) {
        bookingServices.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
