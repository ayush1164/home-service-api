package com.homeservices.booking.service.impl;

import com.homeservices.booking.dto.providerprofile.request.ProviderProfileCreateRequest;
import com.homeservices.booking.dto.providerprofile.response.ProviderProfileResponse;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.User;
import com.homeservices.booking.exception.ResourceNotFoundException;
import com.homeservices.booking.mapper.ProviderProfileMapper;
import com.homeservices.booking.repository.ProviderProfileRepository;
import com.homeservices.booking.repository.UserRepository;
import com.homeservices.booking.service.ProviderProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileProfileServiceImplement implements ProviderProfileService {

    private final ProviderProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProviderProfileMapper profileMapper;

    public ProfileProfileServiceImplement(ProviderProfileRepository profileRepository, UserRepository userRepository, ProviderProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.profileMapper = profileMapper;
    }


    @Override
    public ProviderProfileResponse create(ProviderProfileCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Use not found."));

        ProviderProfile profile = profileMapper.toEntity(request, user);

        ProviderProfile savedProfile = profileRepository.save(profile);

        return profileMapper.toResponse(savedProfile);
    }

    @Override
    public List<ProviderProfileResponse> getAll() {

        return profileRepository.findAll()
                .stream()
                .map(profileMapper::toResponse)
                .toList();
    }

    @Override
    public ProviderProfileResponse getById(Long profileId) {

        ProviderProfile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found."));

        return profileMapper.toResponse(profile);
    }
}
