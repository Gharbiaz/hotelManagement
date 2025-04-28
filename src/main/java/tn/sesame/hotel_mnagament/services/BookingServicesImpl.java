package tn.sesame.hotel_mnagament.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.BookingRequestDTO;
import tn.sesame.hotel_mnagament.DTO.BookingResponseDTO;
import tn.sesame.hotel_mnagament.entity.Booking;
import tn.sesame.hotel_mnagament.repository.BookingRepository;
import tn.sesame.hotel_mnagament.repository.IBookingRepository;
import tn.sesame.hotel_mnagament.services.IBookingServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServicesImpl implements IBookingServices {

    private final BookingRepository bookingRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<BookingResponseDTO> getBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(booking -> modelMapper.map(booking, BookingResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDTO getBooking(long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + id));
        return modelMapper.map(booking, BookingResponseDTO.class);
    }

    @Override
    public BookingResponseDTO addBooking(BookingRequestDTO bookingRequestDTO) {
        Booking booking = modelMapper.map(bookingRequestDTO, Booking.class);
        Booking savedBooking = bookingRepository.save(booking);
        return modelMapper.map(savedBooking, BookingResponseDTO.class);
    }

    @Override
    public BookingResponseDTO updateBooking(long id, BookingRequestDTO bookingRequestDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + id));

        // Map uniquement les champs nécessaires
        modelMapper.map(bookingRequestDTO, booking);

        Booking updatedBooking = bookingRepository.save(booking);
        return modelMapper.map(updatedBooking, BookingResponseDTO.class);
    }

    @Override
    public void deleteBooking(long id) {
        if (!bookingRepository.existsById(id)) {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }
}