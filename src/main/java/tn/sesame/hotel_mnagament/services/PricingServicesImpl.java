package tn.sesame.hotel_mnagament.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.DTO.PricingRequestDTO;
import tn.sesame.hotel_mnagament.DTO.PricingResponseDTO;
import tn.sesame.hotel_mnagament.entity.Pricing;
import tn.sesame.hotel_mnagament.repository.PricingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PricingServicesImpl implements IPricingServices {

    private final PricingRepository pricingRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PricingResponseDTO> getPrices() {
        return pricingRepository.findAll()
                .stream()
                .map(pricing -> modelMapper.map(pricing, PricingResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PricingResponseDTO getPrice(long id) {
        Pricing pricing = pricingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Price not found with id: " + id));
        return modelMapper.map(pricing, PricingResponseDTO.class);
    }

    @Override
    public PricingResponseDTO addPrice(PricingRequestDTO pricingRequestDTO) {
        Pricing pricing = modelMapper.map(pricingRequestDTO, Pricing.class);
        Pricing savedPricing = pricingRepository.save(pricing);
        return modelMapper.map(savedPricing, PricingResponseDTO.class);
    }

    @Override
    public PricingResponseDTO updatePrice(long id, PricingRequestDTO pricingRequestDTO) {
        Pricing pricing = pricingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Price not found with id: " + id));

        // Map only the necessary fields
        modelMapper.map(pricingRequestDTO, pricing);

        Pricing updatedPricing = pricingRepository.save(pricing);
        return modelMapper.map(updatedPricing, PricingResponseDTO.class);
    }

    @Override
    public void deletePrice(long id) {
        if (!pricingRepository.existsById(id)) {
            throw new IllegalArgumentException("Price not found with id: " + id);
        }
        pricingRepository.deleteById(id);
    }
}
