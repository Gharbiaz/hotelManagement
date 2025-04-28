package tn.sesame.hotel_mnagament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sesame.hotel_mnagament.DTO.HotelRequestDTO;
import tn.sesame.hotel_mnagament.DTO.HotelResponseDTO;
import tn.sesame.hotel_mnagament.services.IHotelService;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*") // pour autoriser le frontend à accéder
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    // Get All Hotels
    @GetMapping
    public List<HotelResponseDTO> getHotels() {
        return hotelService.getHotels();
    }

    // Get Hotel by ID
    @GetMapping("/{id}")
    public HotelResponseDTO getHotel(@PathVariable Long id) {
        return hotelService.getHotel(id);
    }

    // Add new Hotel
    @PostMapping
    public HotelResponseDTO addHotel(@RequestBody HotelRequestDTO hotelRequestDTO) {
        return hotelService.addHotel(hotelRequestDTO);
    }

    // Update Hotel
    @PutMapping("/{id}")
    public HotelResponseDTO updateHotel(@PathVariable Long id, @RequestBody HotelRequestDTO hotelRequestDTO) {
        return hotelService.updateHotel(id, hotelRequestDTO);
    }

    // Delete Hotel
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
