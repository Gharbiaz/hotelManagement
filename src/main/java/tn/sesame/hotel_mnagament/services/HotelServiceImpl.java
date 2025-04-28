package tn.sesame.hotel_mnagament.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.HotelRequestDTO;
import tn.sesame.hotel_mnagament.DTO.HotelResponseDTO;
import tn.sesame.hotel_mnagament.entity.Hotel;
import tn.sesame.hotel_mnagament.repository.HotelRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<HotelResponseDTO> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponseDTO getHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
        return modelMapper.map(hotel, HotelResponseDTO.class);
    }

    @Override
    public HotelResponseDTO addHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = modelMapper.map(hotelRequestDTO, Hotel.class);
        Hotel savedHotel = hotelRepository.save(hotel);
        return modelMapper.map(savedHotel, HotelResponseDTO.class);
    }

    @Override
    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isEmpty()) {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
        Hotel existingHotel = optionalHotel.get();
        modelMapper.map(hotelRequestDTO, existingHotel); // mettre à jour les champs
        Hotel updatedHotel = hotelRepository.save(existingHotel);
        return modelMapper.map(updatedHotel, HotelResponseDTO.class);
    }

    @Override
    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
    }
}
