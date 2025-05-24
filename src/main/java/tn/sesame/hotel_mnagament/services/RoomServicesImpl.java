package tn.sesame.hotel_mnagament.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.RoomRequestDto;
import tn.sesame.hotel_mnagament.DTO.RoomResponseDTO;
import tn.sesame.hotel_mnagament.entity.Room;
import tn.sesame.hotel_mnagament.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServicesImpl implements IRoomServices {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<RoomResponseDTO> getRooms() {
        return roomRepository.findAll()
                .stream()
                .map(room -> modelMapper.map(room, RoomResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponseDTO getRoom(long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + id));
        return modelMapper.map(room, RoomResponseDTO.class);
    }

    @Override
    public RoomResponseDTO addRoom(RoomRequestDto roomRequestDTO) {
        Room room = modelMapper.map(roomRequestDTO, Room.class);
        Room savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom, RoomResponseDTO.class);
    }

    @Override
    public RoomResponseDTO updateRoom(long id, RoomRequestDto roomRequestDTO) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + id));

        // Map only the necessary fields
        modelMapper.map(roomRequestDTO, room);

        Room updatedRoom = roomRepository.save(room);
        return modelMapper.map(updatedRoom, RoomResponseDTO.class);
    }

    @Override
    public void deleteRoom(long id) {
        if (!roomRepository.existsById(id)) {
            throw new IllegalArgumentException("Room not found with id: " + id);
        }
        roomRepository.deleteById(id);
    }
}
