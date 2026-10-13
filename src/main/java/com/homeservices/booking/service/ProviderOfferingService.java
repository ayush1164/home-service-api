package com.homeservices.booking.service;

import com.homeservices.booking.dto.provideroffering.request.ProviderOfferingCreateRequest;
import com.homeservices.booking.dto.provideroffering.response.ProviderOfferingResponse;

import java.util.List;

public interface ProviderOfferingService {
    ProviderOfferingResponse create(ProviderOfferingCreateRequest request);

    ProviderOfferingResponse getById(Long offeringId);

    List<ProviderOfferingResponse> getAll();
}
