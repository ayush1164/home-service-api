package com.homeservices.booking.service;

import com.homeservices.booking.dto.providerprofile.request.ProviderProfileCreateRequest;
import com.homeservices.booking.dto.providerprofile.response.ProviderProfileResponse;

import java.util.List;

public interface ProviderProfileService {
    ProviderProfileResponse create(ProviderProfileCreateRequest request);

    List<ProviderProfileResponse> getAll();

    ProviderProfileResponse getById(Long profileId);
}
