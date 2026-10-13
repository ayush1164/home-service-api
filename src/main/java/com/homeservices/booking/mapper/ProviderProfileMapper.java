package com.homeservices.booking.mapper;

import com.homeservices.booking.dto.providerprofile.request.ProviderProfileCreateRequest;
import com.homeservices.booking.dto.providerprofile.response.ProviderProfileResponse;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ProviderProfileMapper {

    public ProviderProfile toEntity(ProviderProfileCreateRequest request, User user){
        if(request == null){
            return null;
        }

        ProviderProfile profile = new ProviderProfile();
        profile.setUser(user);
        profile.setName(request.getName());
        profile.setBio(request.getBio());
        profile.setExperiencedYears(request.getExperiencedYears());
        profile.setIs_available(request.getIs_available());
        profile.setRating(request.getRating());

        return profile;
    }

    public ProviderProfileResponse toResponse(ProviderProfile profile){
        if(profile == null){
            return null;
        }

        ProviderProfileResponse response = new ProviderProfileResponse();
        response.setId(profile.getId());
        response.setName(profile.getName());
        response.setBio(profile.getBio());
        response.setExperiencedYears(profile.getExperiencedYears());
        response.setIs_available(profile.getIs_available());
        response.setRating(profile.getRating());

        // first check if the user is assign or not
        if(profile.getUser() != null){
            response.setUserId(profile.getUser().getId());
        }

        return response;
    }

}
