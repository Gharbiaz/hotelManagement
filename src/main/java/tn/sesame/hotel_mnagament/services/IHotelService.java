package tn.sesame.hotel_mnagament.services;

import tn.sesame.hotel_mnagament.DTO.HotelRequestDTO;
import tn.sesame.hotel_mnagament.DTO.HotelResponseDTO;

import java.util.List;

public interface IHotelService {
    List<HotelResponseDTO> getHotels();
    HotelResponseDTO getHotel(long id);
    HotelResponseDTO addHotel(HotelRequestDTO hotelRequestDTO);
    HotelResponseDTO updateHotel(long id, HotelRequestDTO hotelRequestDTO);
    void deleteHotel(long id);
}
