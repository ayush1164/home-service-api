package com.homeservices.booking.mapper;

import com.homeservices.booking.dto.serviceoffering.request.ServiceOfferingCreateRequest;
import com.homeservices.booking.dto.serviceoffering.response.ServiceOfferingResponse;
import com.homeservices.booking.entity.Category;
import com.homeservices.booking.entity.ServiceOffering;
import org.springframework.stereotype.Component;

@Component
public class ServiceOfferingMapper {

    public ServiceOffering toEntity(ServiceOfferingCreateRequest request, Category category){
        if(request == null){
            return null;
        }

        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setName(request.getName());
        serviceOffering.setDescription(request.getDescription());
        serviceOffering.setPrice(request.getPrice());
        serviceOffering.setCategory(category);

        return serviceOffering;
    }

    public ServiceOfferingResponse toResponse(ServiceOffering serviceOffering){
        if(serviceOffering == null){
            return null;
        }

        ServiceOfferingResponse response = new ServiceOfferingResponse();
        response.setId(serviceOffering.getId());
        response.setName(serviceOffering.getName());
        response.setDescription(serviceOffering.getDescription());
        response.setPrice(serviceOffering.getPrice());

        if(serviceOffering.getCategory() != null){
            response.setCategoryId(serviceOffering.getCategory().getId());
            response.setCategoryName(serviceOffering.getCategory().getName());
        }

        return response;
    }

}
