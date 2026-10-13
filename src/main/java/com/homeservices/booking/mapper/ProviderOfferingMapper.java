package com.homeservices.booking.mapper;

import com.homeservices.booking.dto.provideroffering.request.ProviderOfferingCreateRequest;
import com.homeservices.booking.dto.provideroffering.response.ProviderOfferingResponse;
import com.homeservices.booking.entity.ProviderOffering;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.ServiceOffering;
import org.springframework.stereotype.Component;

@Component
public class ProviderOfferingMapper {

    public ProviderOffering toEntity(
            ProviderOfferingCreateRequest request,
            ProviderProfile profile,
            ServiceOffering service
    ) {
        if (request == null) {
            return null;
        }

        ProviderOffering offering = new ProviderOffering();
        offering.setService(service);
        offering.setProviderProfile(profile);

        return offering;

    }

    public ProviderOfferingResponse toResponse(ProviderOffering offering){
        if(offering == null){
            return null;
        }

        ProviderOfferingResponse response = new ProviderOfferingResponse();
        response.setId(offering.getId());
        if(offering.getProviderProfile() != null){
            response.setProviderId(offering.getProviderProfile().getId());
            response.setProviderName(offering.getProviderProfile().getName());
        }
        if(offering.getProviderProfile() != null){
            response.setServiceId(offering.getService().getId());
            response.setServiceName(offering.getService().getName());
        }

        return response;
    }

}
