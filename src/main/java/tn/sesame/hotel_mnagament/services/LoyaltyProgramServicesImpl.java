package tn.sesame.hotel_mnagament.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.LoyaltyRequestDTO;
import tn.sesame.hotel_mnagament.DTO.LoyaltyResponseDTO;
import tn.sesame.hotel_mnagament.entity.LoyaltyProgram;
import tn.sesame.hotel_mnagament.repository.LoyaltyProgramRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoyaltyProgramServicesImpl implements ILoyaltyProgramServices {

    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<LoyaltyResponseDTO> getLoyaltyPrograms() {
        return loyaltyProgramRepository.findAll()
                .stream()
                .map(loyaltyProgram -> modelMapper.map(loyaltyProgram, LoyaltyResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public LoyaltyResponseDTO getLoyaltyProgram(long id) {
        LoyaltyProgram loyaltyProgram = loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loyalty Program not found with id: " + id));
        return modelMapper.map(loyaltyProgram, LoyaltyResponseDTO.class);
    }

    @Override
    public LoyaltyResponseDTO addLoyaltyProgram(LoyaltyRequestDTO loyaltyProgramRequestDTO) {
        LoyaltyProgram loyaltyProgram = modelMapper.map(loyaltyProgramRequestDTO, LoyaltyProgram.class);
        LoyaltyProgram savedLoyaltyProgram = loyaltyProgramRepository.save(loyaltyProgram);
        return modelMapper.map(savedLoyaltyProgram, LoyaltyResponseDTO.class);
    }

    @Override
    public LoyaltyResponseDTO updateLoyaltyProgram(long id, LoyaltyRequestDTO loyaltyProgramRequestDTO) {
        LoyaltyProgram loyaltyProgram = loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loyalty Program not found with id: " + id));

        // Map only the necessary fields
        modelMapper.map(loyaltyProgramRequestDTO, loyaltyProgram);

        LoyaltyProgram updatedLoyaltyProgram = loyaltyProgramRepository.save(loyaltyProgram);
        return modelMapper.map(updatedLoyaltyProgram, LoyaltyResponseDTO.class);
    }

    @Override
    public void deleteLoyaltyProgram(long id) {
        if (!loyaltyProgramRepository.existsById(id)) {
            throw new IllegalArgumentException("Loyalty Program not found with id: " + id);
        }
        loyaltyProgramRepository.deleteById(id);
    }
}
