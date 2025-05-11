package tn.sesame.hotel_mnagament.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.HotelRequestDTO;
import tn.sesame.hotel_mnagament.DTO.HotelResponseDTO;
import tn.sesame.hotel_mnagament.entity.Hotel;
import tn.sesame.hotel_mnagament.repository.HotelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServicesImpl implements IHotelServices {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<HotelResponseDTO> getHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponseDTO getHotel(long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with id: " + id));
        return modelMapper.map(hotel, HotelResponseDTO.class);
    }

    @Override
    public HotelResponseDTO addHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = modelMapper.map(hotelRequestDTO, Hotel.class);
        Hotel savedHotel = hotelRepository.save(hotel);
        return modelMapper.map(savedHotel, HotelResponseDTO.class);
    }

    @Override
    public HotelResponseDTO updateHotel(long id, HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with id: " + id));

        // Map only the necessary fields
        modelMapper.map(hotelRequestDTO, hotel);

        Hotel updatedHotel = hotelRepository.save(hotel);
        return modelMapper.map(updatedHotel, HotelResponseDTO.class);
    }

    @Override
    public void deleteHotel(long id) {
        if (!hotelRepository.existsById(id)) {
            throw new IllegalArgumentException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
    }
}
