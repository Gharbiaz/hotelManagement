package tn.sesame.hotel_mnagament.services;

import tn.sesame.hotel_mnagament.DTO.UserRequestDTO;
import tn.sesame.hotel_mnagament.DTO.UserResponseDTO;

import java.util.List;

public interface IUserServices {
    List<UserResponseDTO> getUsers();
    UserResponseDTO getUser(long id);
    UserResponseDTO addUser(UserRequestDTO userRequestDTO);
    UserResponseDTO updateUser(long id, UserRequestDTO userRequestDTO);
    void deleteUser(long id);
}
