package com.homeservices.booking.service;

import com.homeservices.booking.dto.serviceoffering.request.ServiceOfferingCreateRequest;
import com.homeservices.booking.dto.serviceoffering.response.ServiceOfferingResponse;

import java.util.List;

public interface ServiceOfferingService {
    ServiceOfferingResponse create(ServiceOfferingCreateRequest request);

    ServiceOfferingResponse get(Long serviceId);

    List<ServiceOfferingResponse> getAll();
}
