package tn.sesame.hotel_mnagament.services;


import tn.sesame.hotel_mnagament.DTO.BookingRequestDTO;
import tn.sesame.hotel_mnagament.DTO.BookingResponseDTO;

import tn.sesame.hotel_mnagament.entity.Booking;

import java.util.List;

public interface IBookingServices {


    List<BookingResponseDTO> getBookings();
    BookingResponseDTO getBooking(long id);
    BookingResponseDTO addBooking(BookingRequestDTO bookingRequestDTO);
    BookingResponseDTO updateBooking(long id, BookingRequestDTO bookingRequestDTO);
    void deleteBooking(long id);

}