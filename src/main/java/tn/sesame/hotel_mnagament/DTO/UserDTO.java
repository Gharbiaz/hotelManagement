package tn.sesame.hotel_mnagament.dto;



import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;
}
