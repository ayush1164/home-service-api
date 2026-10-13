package com.homeservices.booking.service.impl;

import com.homeservices.booking.dto.serviceoffering.request.ServiceOfferingCreateRequest;
import com.homeservices.booking.dto.serviceoffering.response.ServiceOfferingResponse;
import com.homeservices.booking.entity.Category;
import com.homeservices.booking.entity.ServiceOffering;
import com.homeservices.booking.exception.ResourceNotFoundException;
import com.homeservices.booking.mapper.ServiceOfferingMapper;
import com.homeservices.booking.repository.CategoryRepository;
import com.homeservices.booking.repository.ServiceOfferingRepository;
import com.homeservices.booking.service.ServiceOfferingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfferingImplementation implements ServiceOfferingService {

    private final ServiceOfferingRepository serviceRepository;
    private final CategoryRepository categoryRepository;
    private final ServiceOfferingMapper offeringMapper;

    public ServiceOfferingImplementation(ServiceOfferingRepository serviceRepository, CategoryRepository categoryRepository, ServiceOfferingMapper offeringMapper) {
        this.serviceRepository = serviceRepository;
        this.categoryRepository = categoryRepository;
        this.offeringMapper = offeringMapper;
    }

    @Override
    public ServiceOfferingResponse create(ServiceOfferingCreateRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        ServiceOffering serviceOffering = offeringMapper.toEntity(request, category);

        ServiceOffering savedServiceOffering = serviceRepository.save(serviceOffering);

        return offeringMapper.toResponse(savedServiceOffering);
    }

    @Override
    public ServiceOfferingResponse get(Long serviceId) {

        ServiceOffering serviceOffering = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service Offering not found"));

        return offeringMapper.toResponse(serviceOffering);
    }

    @Override
    public List<ServiceOfferingResponse> getAll() {
        List<ServiceOffering> serviceOfferings = serviceRepository.findAll();

        return serviceOfferings.stream()
                .map(offeringMapper::toResponse)
                .toList();
    }

}
