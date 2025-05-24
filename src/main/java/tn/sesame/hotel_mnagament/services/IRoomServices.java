package tn.sesame.hotel_mnagament.services;

import tn.sesame.hotel_mnagament.DTO.RoomRequestDto;
import tn.sesame.hotel_mnagament.DTO.RoomResponseDTO;

import java.util.List;

public interface IRoomServices {
    List<RoomResponseDTO> getRooms();
    RoomResponseDTO getRoom(long id);
    RoomResponseDTO addRoom(RoomRequestDto roomRequestDTO);
    RoomResponseDTO updateRoom(long id, RoomRequestDto roomRequestDTO);
    void deleteRoom(long id);
}
