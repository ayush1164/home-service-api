package com.homeservices.booking.service.impl;

import com.homeservices.booking.dto.provideroffering.request.ProviderOfferingCreateRequest;
import com.homeservices.booking.dto.provideroffering.response.ProviderOfferingResponse;
import com.homeservices.booking.entity.ProviderOffering;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.ServiceOffering;
import com.homeservices.booking.exception.BusinessRuleException;
import com.homeservices.booking.exception.ResourceNotFoundException;
import com.homeservices.booking.mapper.ProviderOfferingMapper;
import com.homeservices.booking.repository.ProviderOfferingRepository;
import com.homeservices.booking.repository.ProviderProfileRepository;
import com.homeservices.booking.repository.ServiceOfferingRepository;
import com.homeservices.booking.service.ProviderOfferingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderOfferingServiceImplement implements ProviderOfferingService {

    private final ProviderOfferingRepository providerOfferingRepository;
    private final ProviderProfileRepository providerProfileRepository;
    private final ServiceOfferingRepository serviceOfferingRepository;
    private final ProviderOfferingMapper offeringMapper;

    public ProviderOfferingServiceImplement(
            ProviderOfferingRepository providerOfferingRepository,
            ProviderProfileRepository providerProfileRepository,
            ServiceOfferingRepository serviceOfferingRepository,
            ProviderOfferingMapper offeringMapper
            ){
        this.providerOfferingRepository = providerOfferingRepository;
        this.serviceOfferingRepository = serviceOfferingRepository;
        this.providerProfileRepository = providerProfileRepository;
        this.offeringMapper = offeringMapper;
    }

    @Override
    public ProviderOfferingResponse create(ProviderOfferingCreateRequest request) {

        boolean alreadyExist =
                providerOfferingRepository
                        .existsByProviderProfileIdAndServiceId(
                                request.getProviderId(),
                                request.getServiceId()
                        );

        if (alreadyExist) {
            throw new BusinessRuleException(
                    "This provider already offers this service"
            );
//            This rejects an identical relationship before inserting it.
        }

        ProviderProfile profile = providerProfileRepository.findById(request.getProviderId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(request.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        ProviderOffering providerOffering = offeringMapper.toEntity(
                request,
                profile,
                serviceOffering
        );

        ProviderOffering savedProviderOffering = providerOfferingRepository.save(providerOffering);

        return offeringMapper.toResponse(savedProviderOffering);
    }

    @Override
    public ProviderOfferingResponse getById(Long offeringId) {

        ProviderOffering offering = providerOfferingRepository.findById(offeringId)
                .orElseThrow(() -> new ResourceNotFoundException("Offering not found"));

        return offeringMapper.toResponse(offering);
    }

    public List<ProviderOfferingResponse> getAll(){
        return providerOfferingRepository.findAll()
                .stream()
                .map(offeringMapper::toResponse)
                .toList();
    }
}
